package ch.zhaw.homework.le05a.task04_test;

import org.apache.logging.log4j.core.lookup.SystemPropertiesLookup;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class nioClassTestBo {

    public static void main(String[] args) {

        String pathToDesktopContent = "/home/bonux/Desktop"; //file separator not set here at the end
        String pathToFileTTK = "/home/bonux/Desktop/tempToKill"; //file separator not set here at the end
        String newFolderName = "newFolder"; //shall be named new to make it clear
        String fileName = "myFirstTestFile"; // give a more funny name if you are more creative then I am
        String existingTxt = "helloPascaltext.txt";
        String newTxt = "newTxt.txt";
        String dir = System.getProperty(pathToFileTTK);

        // -- 0 --
        // show some results from the Path class methods <NIO>
        Path path1 = Paths.get(pathToFileTTK);
        System.out.println("**show some results from the Path class methods (NIO)**");
        //one folder above, like cd .. here /home/bonux/Desktop
        System.out.println(">show...path1.getParent() of tempToKill: " +path1.getParent());
        System.out.println(">show...path1.getRoot(): " +path1.getRoot()); //is null when relative path
        System.out.println(">show...path1.getFileName(): " +path1.getFileName()); // tempToKill
        // Absolut Path is: /home/bonux/Desktop/tempToKill
        System.out.println(">show...path1.toAbsolutePath(): " +path1.toAbsolutePath());
        //Subpath shows: shome/bonux/Desktop/tempToKill
        System.out.println(">show...path1.subpath(0,3) is (0 up to 2): " +path1.subpath(0,3));
        //Result is: sun.nio.fs.LinuxFileSystem@5cad8086
        System.out.println(">show...FileSystems.getDefault(): " + FileSystems.getDefault());


        // -- 1 --
        // choose a folder and show its  next sub directories, not recursive
        System.out.println("\n**********get sub files**********");
        System.out.println("**********Double colon (::) operator**********");
        System.out.println("**list.forEach(System.out::println);**");
        Path path2 = Paths.get(pathToDesktopContent + File.separator);

        Stream<Path> list = null;
        try {
            list = Files.list(path2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // https://www.geeksforgeeks.org/double-colon-operator-in-java/
        //<Class name>::<method name>
        list.limit(5).forEach(System.out::println);

        System.out.println("\n**********or an example with a lambda**********");
        System.out.println("**list2.forEach(s -> System.out.println(s));**");

        //or here an example with a lambda
        Stream<Path> list2 = null;
        try {
            list2 = Files.list(path2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // https://www.geeksforgeeks.org/double-colon-operator-in-java/
        //Stream<T>.forEach( s-> System.out.println(s));
        list2.limit(5).forEach(s -> System.out.println(s));

        // -- 2 --
        // create a new file in to a path you like
        // here e.g my own tempToKill folder located in Desktop and put in a text
        System.out.println("\n**********create a file and put in some text**********");
        Path file = Paths.get(pathToFileTTK, newTxt);

        //if the file already exists, it does overwrite
        try(BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            System.out.println("file successfully created");


            writer.write("Das ist mein erster Test\n" +
                             "um in einen Ordner ausserhalb zu schreiben"
                              +"\ncontent created @: "
                                + LocalDateTime.now()); //yyyy-m-dTh:m:s.ms
        }
        catch (FileNotFoundException fnfe ) {
            System.out.println(file +"File not found");
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // --3 --
        // read the existing file here is simple and elegant. Or check below
        System.out.println("\n**********read file elegant*********");
        try {
            List<String> txtContent = Files.readAllLines(file, StandardCharsets.UTF_8);
            for(String text :  txtContent) {
                System.out.println(text);
            }
            System.out.println("\nDate and time at time reading this: "
                    + LocalDateTime.now()); //yyyy-m-dTh:m:s.ms
        } catch (IOException e) {
            e.printStackTrace();
        }


        // --4 --
        // or with the standard reader idea
        System.out.println("\n**********read file with the BufferReader*********");
        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            String textLine = reader.readLine();

            while (textLine != null) {
                System.out.println(textLine);
                textLine = reader.readLine();
            }
            System.out.println("\nDate and time at time reading this: "
                    + LocalDateTime.now()); //yyyy-m-dTh:m:s.ms
        }
        catch (FileNotFoundException fnfe ) {
            System.out.println(path2 +"File not found");
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

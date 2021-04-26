package ch.zhaw.homework.le05a.task03b_tests;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileClassTestBo {

    public static void main(String[] args) {

        String pathToDesktopContent = "/home/bonux/Desktop"; //file separator not set here at the end
        String pathToFileTTK = "/home/bonux/Desktop/tempToKill"; //file separator not set here at the end
        String newFolderName = "newFolder"; //shall be named new to make it clear
        String fileName = "myFirstTestFile"; // give a more funny name if you are more creative then I am
        String existingTxt = "helloPascaltext.txt";
        //String folderPath = System.getProperty("user.home") + File.separator + folderName; and may again a separator

        // -- 0 --
        // show some results from the File class methods
        System.out.println("\n**show some results from the File class methods**");
        File file = new File(pathToFileTTK +File.separator);
        System.out.println(">show...getAbsolutPath: " +file.getAbsolutePath());
        System.out.println(">getProperty(user.home):" +System.getProperty("user.home"));
        System.out.println("\n**show file separators on *nix machine**");
        System.out.println(">File.separator = "+File.separator);
        System.out.println(">File.separatorChar = "+File.separatorChar);
        System.out.println(">File.pathSeparator = "+File.pathSeparator);
        System.out.println(">File.pathSeparatorChar = "+File.pathSeparatorChar);
        System.out.println(">show..System.getProperty(file.separator): " +System.getProperty("file.separator"));


        // -- 1 --
        // choose a folder and show its  next sub directories, not recursive
        System.out.println("\n**********get sub files**********");
        File file1 = new File(pathToDesktopContent +File.separator);
        //file.list()-> returns an array of strings naming the files and directories in the directory
        String[] dir = file1.list();

        // copy the content fetched with file.list() in to e.g entry
        assert dir != null; //special for <if(){}> for developers in dev environments/branches
        for (String entry : dir) {
            System.out.println(">one of the files in Desktop file is: " +entry);
        }


        // -- 2 --
        // create a new folder in to a path you like
        // here e.g my own tempToKill folder located in Desktop
        System.out.println("\n**********create a file (mkdir)**********");
        File file2 = new File(pathToFileTTK +File.separator +newFolderName);

        if (!file2.exists()) {
            file2.mkdir();
            System.out.println(">Folder <" + newFolderName + "> successfully created");
            System.out.println(">folder size: " +file2.length());
        }
        else {
            System.out.println(">Folder <" + newFolderName + "> already exist");
        }


        // -- 3 --
        // open an existing file and print the file size
        System.out.println("\n**********get file-size**********");
        File file3 = new File(pathToFileTTK +File.separator +existingTxt);
        if (file3.exists()) {
            System.out.println(">length of <"+existingTxt +">: " + file3.length());
        }
        else {
            System.out.println(">" +existingTxt +pathToFileTTK +" can not be found or do not exist on this dir");
        }

        // -- 4 --
        // open an existing file and print the content in to the terminal
        //File file4 = new File(pathToFileTTK +File.separator +existingTxt);
        System.out.println("\n**********read file from a directory**********");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                pathToFileTTK +File.separator +existingTxt),
                                StandardCharsets.UTF_8))) {

            String line = reader.readLine();
            //I point here to the same txt as in example file3,
            // so i do not create a new one just for this read. so I take file3.length();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            System.out.println("\n>the system related line feed is not counted");
            System.out.println(">line feeds: " +(file3.length()-152) );
            System.out.println(">length of <"+existingTxt +">: " + file3.length());

        }
        catch (FileNotFoundException e) {
            System.out.println(">file in <" +pathToFileTTK + "> not found");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    } // main
} //class

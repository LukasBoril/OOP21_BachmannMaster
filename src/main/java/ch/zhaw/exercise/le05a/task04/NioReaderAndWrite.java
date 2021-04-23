package ch.zhaw.exercise.le05a.task04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NioReaderAndWrite {

    public static void main(String[] args) {

        String pathToPackage = "src/main/java/ch/zhaw/exercise/le05a/task04/";

        Path file = Paths.get(pathToPackage + "nio.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)){
            writer.write("Hallo Zusammen." + System.getProperty("line.separator"));
            writer.write("Dies wurde mit Java 7 Funktionalität gemacht.");
        } catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)){
            String s;
            while ((s = reader.readLine()) != null){
                System.out.println(s);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("elegant:");
        try {
            List<String> allLines = Files.readAllLines(file, StandardCharsets.UTF_8);
            for (String line : allLines){
                System.out.println(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

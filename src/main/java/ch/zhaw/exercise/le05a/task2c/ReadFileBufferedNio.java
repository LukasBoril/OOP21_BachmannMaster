package ch.zhaw.exercise.le05a.task2c;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFileBufferedNio {

    public static void main(String[] args) {

        String pathToPackage = "src/main/java/ch/zhaw/exercise/le05a/";
        String filePath = pathToPackage + "personen-crlf-utf8.txt";
        File file = new File(filePath);
        System.out.println(File.pathSeparator + " " + File.separator);

        Path path = file.toPath();
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String zeile = reader.readLine();
            while (zeile != null) {
                System.out.println(zeile);
                zeile = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(path + " nicht gefunden");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

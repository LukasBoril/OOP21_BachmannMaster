package ch.zhaw.exercise.le05a.task2b;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadAllFile {

    public static void main(String[] args) {

        String pathToPackage = "src/main/java/ch/zhaw/exercise/le05a/";
        String filePath = pathToPackage + "personen-crlf-utf8.txt";
        File file = new File(filePath);
        int length = (int)file.length() ;

        // FileReader akzeptiert ab JDK 11 ein Charset new FileReader(fileName, charset).
        // JDK8: new FileReader(filePath) ersetzen durch new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {

            char[] buffer = new char[length] ;
            int numberOfCharacters = reader.read(buffer) ;
            String text = new String(buffer, 0, numberOfCharacters);
            System.out.println("fileSize=" + length + ", numberOfCharacters=" + numberOfCharacters + "\n" + text);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

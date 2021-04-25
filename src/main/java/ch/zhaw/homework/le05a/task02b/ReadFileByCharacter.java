package ch.zhaw.homework.le05a.task02b;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadFileByCharacter {

    public static void main(String[] args) {

        String pathToPackage = "src/main/java/ch/zhaw/homework/le05a/";
        String filePath = pathToPackage + "personen-crlf-utf8.txt";
        File file = new File(filePath);
        int length = (int)file.length() ;

        // FileReader akzeptiert ab JDK 11 ein Charset new FileReader(fileName, charset).
        // JDK8: new FileReader(filePath) ersetzen durch
        // new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))
        // unser cas-oop-21-11-java Kurs Branch läuft alles auf JDK-8
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            StringBuilder stringBuilder = new StringBuilder();

            int character;

            while( (character = reader.read()) != -1 ) {
                stringBuilder.append((char) character);
            }
            System.out.println("fileSize=" + length +
                    ", numberOfCharacters=" + stringBuilder.length() + "\n" +
                    stringBuilder.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

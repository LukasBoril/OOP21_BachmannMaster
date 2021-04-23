package ch.zhaw.exercise.le05a.task02b;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadFileByCharacter {

    public static void main(String[] args) {
        String pathToPackage = "src/main/java/ch/zhaw/exercise/le05a/";
        String filePath = pathToPackage + "personen-crlf-utf8.txt";

        File file = new File(filePath);
        int length = (int)file.length();

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)){

            char[] buffer = new char[length];
            int numberOfCharacters = reader.read(buffer);
            String text = new String(buffer, 0, numberOfCharacters);
            StringBuilder stringBuilder = new StringBuilder();
            System.out.println("fileSize= " + length + ", numberOfCharacters= " + numberOfCharacters + "\n" + text);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

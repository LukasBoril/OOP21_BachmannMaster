package ch.zhaw.exercise.le05a.task02a;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadFileByCharacter {

    public static void main(String[] args) {
        String pathToPackage = "src/main/java/ch/zhaw/exercise/le05a/";
        String filePath = pathToPackage + "personen-crlf-utf8.txt";

        File file = new File(filePath);
        int length = (int)file.length();

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)){

            StringBuilder stringBuilder = new StringBuilder();
            int character;
            while ((character = reader.read()) != -1){
                stringBuilder.append((char) character);
            }
            System.out.println("filesize: " + length + ", numberOfCharacters= " + stringBuilder.length() + "\n" +
                    stringBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

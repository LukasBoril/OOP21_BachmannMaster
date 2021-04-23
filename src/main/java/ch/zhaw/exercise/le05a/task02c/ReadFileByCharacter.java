package ch.zhaw.exercise.le05a.task02c;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadFileByCharacter {

    public static void main(String[] args) {
        String pathToPackage = "src/main/java/ch/zhaw/exercise/le05a/";
        String filePath = pathToPackage + "personen-crlf-utf8.txt";

        File file = new File(filePath);
        int length = (int)file.length();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath), StandardCharsets.UTF_8)
                )
        ){
            String line = reader.readLine();
            while (line != null){
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

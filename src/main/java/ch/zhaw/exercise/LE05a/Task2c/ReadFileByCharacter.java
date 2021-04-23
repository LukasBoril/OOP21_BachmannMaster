package ch.zhaw.exercise.LE05a.Task2c;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadFileByCharacter {
    public static void main(String[] args) {
        String pathToPackage = "src/main/java/ch/zhaw/exercise/LE05a/";
        String filePath = pathToPackage + "personen-lf-utf8.txt";
        File file = new File(filePath);
        int length = (int)file.length() ;

        // FileReader akzeptiert ab JDK 11 ein Charset new FileReader(fileName, charset).
// JDK8: new FileReader(filePath) ersetzen durch
// new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))
        try (BufferedReader reader = new BufferedReader( new InputStreamReader(
                new FileInputStream(filePath), StandardCharsets.UTF_8)
        )) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine(); }
        } catch (FileNotFoundException e) {
            System.out.println(filePath + " nicht gefunden");
        } catch (IOException e) {
            e.printStackTrace();
        } }

}

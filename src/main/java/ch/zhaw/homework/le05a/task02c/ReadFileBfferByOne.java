package ch.zhaw.homework.le05a.task02c;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadFileBfferByOne {

    public static void main(String[] args) {

        String pathToPackage = "src/main/java/ch/zhaw/homework/le05a/";
        String filePath = pathToPackage + "personen-crlf-utf8.txt";
        File file = new File(filePath);
        int length = (int)file.length() ;

        // FileReader akzeptiert ab JDK 11 ein Charset new FileReader(fileName, charset).
        // JDK8: new FileReader(filePath) ersetzen durch
        // new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))
        // unser cas-oop-21-11-java Kurs Branch läuft alles auf JDK-8
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath), StandardCharsets.UTF_8))) {

            String line = reader.readLine();
            System.out.println("file size: " +length); //+"number of characters: " +stringBuilder.length());

            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(filePath + " nicht gefunden");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    } //main
} //class

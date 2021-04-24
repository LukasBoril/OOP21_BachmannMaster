package ch.zhaw.homework.le05a.task01b;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriterPrint {

    public static void main(String[] args) {
        String pathToPackage = "src/main/java/ch/zhaw/homework/le05a/task01b/";
        File file = new File(pathToPackage + "task01bDatei.txt");

        // Append flag is set to true
        try (FileWriter fw = new FileWriter(file, true);
             PrintWriter out = new PrintWriter(fw)) {
            out.println("Bo_LE05_task01b"); //is appended below first entry Bo...

            System.out.println("successfully wrote in to: " + file);    //Terminal info

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

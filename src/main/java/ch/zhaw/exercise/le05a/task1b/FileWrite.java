package ch.zhaw.exercise.le05a.task1b;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWrite {
    private static String pathToPackage = "src/main/java/ch/zhaw/exercise/le05a/task1b/";
    private static File file = new File(pathToPackage + "datei.txt");

    //Konstruktor
    public FileWrite() {
    }


    //Mainmethode to write into the file
    public static void main(String[] args) {

        try (FileWriter fw = new FileWriter(file, true)) {
            PrintWriter out = new PrintWriter(fw);

            out.println("bla");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

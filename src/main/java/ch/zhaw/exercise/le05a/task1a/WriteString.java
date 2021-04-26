package ch.zhaw.exercise.le05a.task1a;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteString {

    private static String pathToPackage = "src/main/java/ch/zhaw/exercise/le05a/task1a/";
    private static File file = new File(pathToPackage + "datei.txt");

    //Konstruktor
    public WriteString() {
    }


    //Mainmethode to write into the file
    public static void main(String[] args) {

        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("Bla1\n");
            fw.write("Bla2\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package ch.zhaw.exercise.le05a.task01b;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintStringToFile {

    public static void main(String[] args) {
        String pathToPackage = "src/main/java/ch/zhaw/exercise/le05a/task01b/";
        File file = new File(pathToPackage + "datei.txt");

        try (FileWriter fw = new FileWriter(file, true);
            PrintWriter out = new PrintWriter(fw)){
                out.println("bla2");
            } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

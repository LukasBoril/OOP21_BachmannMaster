package ch.zhaw.exercise.le05a.task01a;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrintStringToFile {

    public static void main(String[] args) {
        String pathToPackage = "src/main/java/ch/zhaw/exercise/le05a/task01a/";
        File file = new File(pathToPackage + "datei.txt");

        try (FileWriter fw = new FileWriter(file, true)){
            fw.write("bla1\n");
            fw.write("bla2\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

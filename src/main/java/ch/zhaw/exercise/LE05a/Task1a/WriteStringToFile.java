package ch.zhaw.exercise.LE05a.Task1a;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteStringToFile {
    public static void main(String[] args) {


        String pathToPackage = "src/main/java/ch/zhaw/exercise/LE05a/Task1a/";
        File file = new File(pathToPackage + "datei.txt");
// Append flag is set to true
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("bla1\n");
            fw.write("bla2\n");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}

package ch.zhaw.homework.le05a.task01a;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterWrite {

    public static void main(String[] args) {
        String pathToPackage = "src/main/java/ch/zhaw/homework/le05a/task01a/";
        File file = new File(pathToPackage + "datei.txt");

        // Append flag is set to true
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("Bo1_LE05_task01a\n");
            fw.write("Bo2_LE05_task01a\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

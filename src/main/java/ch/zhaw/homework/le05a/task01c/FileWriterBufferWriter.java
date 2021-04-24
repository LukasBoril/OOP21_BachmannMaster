package ch.zhaw.homework.le05a.task01c;

import java.io.*;

public class FileWriterBufferWriter {
    public static void main(String[] args) {
        String pathToPackage = "src/main/java/ch/zhaw/homework/le05a/task01c/";
        File file = new File(pathToPackage + "datei.txt");
// Append flag is set to true
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println("Bo_LE05_task01c");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

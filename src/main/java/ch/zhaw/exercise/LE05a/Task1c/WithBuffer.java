package ch.zhaw.exercise.LE05a.Task1c;

import java.io.*;

public class WithBuffer {
    public static void main(String[] args) {
        String pathToPackage = "src/main/java/ch/zhaw/exercise/le05a/task1c/";
        File file = new File(pathToPackage + "datei.txt");

// Append flag is set to true
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println("bla2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

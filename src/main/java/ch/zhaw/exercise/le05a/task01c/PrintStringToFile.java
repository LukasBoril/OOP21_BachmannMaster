package ch.zhaw.exercise.le05a.task01c;

import java.io.*;

public class PrintStringToFile {

    public static void main(String[] args) {
        String pathToPackage = "src/main/java/ch/zhaw/exercise/le05a/task01c/";
        File file = new File(pathToPackage + "datei.txt");

        try (FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)){
                out.println("bla2");
            } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

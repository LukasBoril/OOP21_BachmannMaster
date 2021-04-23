package ch.zhaw.exercise.LE05a.Task1d;

import java.io.*;

public class PrintWithBufferStringToFile {

    public static void main(String[] args) {

        File file = new File("src/main/java/ch/zhaw/exercise/le05a/task1d/datei.txt");
        long start = 0;
        // Append flag is set to true
        try (FileWriter fw = new FileWriter(file, false);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            start = System.currentTimeMillis();
            for (int i = 0; i < 1_000_000; i++) {
                out.println("a");
            }
            out.write("\n" + " Ende");

        } catch (IOException e) {
            e.printStackTrace();
        }
        long stop = System.currentTimeMillis();
        System.out.println("Zeit: " + (stop - start) + " millisekunden");

    }
}

package ch.zhaw.homework.le05a.task01d;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriterBufferTime {

    public static void main(String[] args) {

        File file = new File("src/main/java/ch/zhaw/homework/le05a/task01d/");
        long start=0;
        // Append flag is set to true
        try (FileWriter fw = new FileWriter(file, false);
             PrintWriter out = new PrintWriter(fw)) {

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


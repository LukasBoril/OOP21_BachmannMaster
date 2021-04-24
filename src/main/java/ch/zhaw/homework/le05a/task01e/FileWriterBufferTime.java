package ch.zhaw.homework.le05a.task01e;

import java.io.*;

public class FileWriterBufferTime {


    public static void main(String[] args) {
        String pathToPackage = "src/main/java/ch/zhaw/homework/le05a/task01e/";
        File file = new File(pathToPackage + "task01eDatei.txt");
        long start = 0;

        // Append flag is set to false
        try (FileWriter fw = new FileWriter(file, false);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            // take the current system time
            start = System.currentTimeMillis();

            for (int i = 0; i < 1_000_000; i++) {
                out.write("b"); //is all the time overwritten
            }
            out.write("\n" + " Ende");

        } catch (IOException e) {
            e.printStackTrace();
        }

        long stop = System.currentTimeMillis();
        System.out.println(new StringBuilder().append("Time: ")
                            .append(stop - start).append(" in milliseconds").toString());
    }
}

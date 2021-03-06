package ch.zhaw.exercise.le05a.task1d;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintStringToFile {

	public static void main(String[] args) {

		File file = new File("src/main/java/ch/zhaw/exercise/le05a/task1d/datei.txt");
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

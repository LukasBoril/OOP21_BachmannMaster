package ch.zhaw.exercise.le05a.task1b;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintStringToFile {

	public static void main(String[] args) {

		String pathToPackage = "src/main/java/ch/zhaw/exercise/le05a/task1b/";
		File file = new File(pathToPackage + "datei.txt");
		// Append flag is set to true
		try (FileWriter fw = new FileWriter(file, true);
			 PrintWriter out = new PrintWriter(fw)) {

			out.println("bla2äöü");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

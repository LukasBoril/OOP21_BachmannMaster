package ch.zhaw.exercise.le05a.task2c;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFileBuffered {

	public static void main(String[] args) {

		String pathToPackage = "src/main/java/ch/zhaw/exercise/le05a/";
		String filePath = pathToPackage + "personen-crlf-utf8.txt";
		File file = new File(filePath);
		// FileReader akzeptiert ab JDK 11 ein Charset new FileReader(fileName, charset).
		// JDK8: FileReader ersetzen durch new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(filePath), StandardCharsets.UTF_8)
		)) {

			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println(filePath + " nicht gefunden");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

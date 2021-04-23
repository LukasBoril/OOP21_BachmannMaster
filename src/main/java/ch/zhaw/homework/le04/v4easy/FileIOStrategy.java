package ch.zhaw.homework.le04.v4easy;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * IOStrategy to load and save decision to a file using strings
 */
public class FileIOStrategy implements IOStrategy {

	@Override
	public List<String> load(String fileName) throws IOException,
	ClassNotFoundException {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			List<String> decisions = new ArrayList<>();

			String decision = reader.readLine();
			while (decision != null) {
				decisions.add(decision);
				decision = reader.readLine();
			}
			return decisions;
		}
	}

	@Override
	public void save(String fileName, List<String> decisions) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

			for (String string : decisions) {
				writer.write(string);
				writer.newLine();
			}
		}
	}

}

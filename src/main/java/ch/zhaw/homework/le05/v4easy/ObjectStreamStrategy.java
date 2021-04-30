package ch.zhaw.homework.le05.v4easy;


import java.io.*;
import java.util.List;

/**
 * IOStrategy to load and save decisions with serialization
 */
public class ObjectStreamStrategy implements IOStrategy {

	public void save(String fileName, List<String> decisions) throws IOException {
		try (OutputStream outStream = new FileOutputStream(fileName);
			 ObjectOutputStream outObject = new ObjectOutputStream(outStream)) {

			outObject.writeObject(decisions);

		} catch (IOException e) {
			throw new IOException("Daten können nicht in der Datei " + fileName + " gespeichert werden!");
		}
	}

	@SuppressWarnings("unchecked")
	public List<String> load(String fileName) throws IOException, ClassNotFoundException {

		try (InputStream inStream = new FileInputStream(fileName);
			 ObjectInputStream inObject = new ObjectInputStream(inStream)) {
			 return (List<String>) inObject.readObject();

		} catch (ClassNotFoundException | IOException e) {
			throw new IOException("Die Daten können nicht von der Datei " + fileName + " gelesen werden");
		}
	}
}

package ch.zhaw.exercise.le05a.task5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class NioExplainPathAndFiles {

	public static void main(String[] args) throws IOException {

		String pathToPackage = "src/main/java/ch/zhaw/exercise/le05a/task5/";

		// Vor Java 7
		File file = new File(pathToPackage);
		System.out.println("isDirectory=" + file.isDirectory() + ", isFile=" + file.isFile());
		try (FileWriter fw = new FileWriter(pathToPackage + "test.txt", true)) {
			fw.write("bla1\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Java 7
		Files.copy(Paths.get(pathToPackage + "test.txt"), Paths.get(pathToPackage + "test-copy.txt"));
		Path path = Paths.get(pathToPackage + "test-copy.txt");
		boolean deleteIfExists = Files.deleteIfExists(path);
		System.out.println("Delete File If Exists: " + deleteIfExists);
		System.out.println("getFileName: " + path.getFileName());
		System.out.println("toAbsolutePath: " + path.toAbsolutePath());
		System.out.println("getName: " + path.getName(1));
		System.out.println("getParent: " + path.getParent());
		System.out.println("subpath: " + path.subpath(0, 2));

		// Java6-File nach Java7-Path transformieren:
		Path tPath = new File(pathToPackage + "test.txt").toPath();
		System.out.println("toAbsolutePath: " + tPath.toAbsolutePath());

		// Files (Java 7)
		System.out.println("isRegularFile: " + Files.isRegularFile(path));
		System.out.println("exists: " + Files.exists(path));
		// File erstellen
		System.out.println("createFile: " + Files.createFile(path));
		System.out.println("isRegularFile: " + Files.isRegularFile(path));
		System.out.println("exists: " + Files.exists(path));
		System.out.println("isReadable: " + Files.isReadable(path));

		// Ordner erstellen
		Path ordner = Paths.get(pathToPackage + "new-folder");
		Files.createDirectories(ordner);


	}


}




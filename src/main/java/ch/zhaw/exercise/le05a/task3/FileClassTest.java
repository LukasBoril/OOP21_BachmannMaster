package ch.zhaw.exercise.le05a.task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileClassTest {

    public static void main(String[] args) {
        String path = "src";
        String pathToPackage = "src/main/java/ch/zhaw/exercise/le05a/";

        // -- 1 --
        // get files and folder in the src path
        File file = new File(path);
        String[] dir = file.list();

        // src contains main and test (maven standard structure)
        assert dir != null;
        for (String entry : dir) {
            System.out.println(entry);
        }

        System.out.println(file.getAbsolutePath());

        // -- 2 --
        // open an existing file and print the file size
        File file2 = new File(pathToPackage + "personen-crlf-utf8.txt");
        if (file2.exists()) {
            System.out.println("length: " + file2.length());
        }

        // -- 3 --
        // create a new folder
        File file3 = new File(pathToPackage + "newFolder");
        file3.mkdir();

        // create a new file in the new folder and write bla to it
        File file4 = new File(pathToPackage + "newFolder/blabla.txt");
        try (FileWriter fw = new FileWriter(file4)) {
            fw.append("bla\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // -- 4 --
        // create a new folder and move the file blabla.txt to the new folder2 and rename it to test.txt
        File file5 = new File(pathToPackage + "newFolder2");
        file5.mkdir();
        File file6 = new File(pathToPackage + "newFolder2/test.txt");
        if (file4.exists()) {
            file4.renameTo(file6);
        }
    }

}

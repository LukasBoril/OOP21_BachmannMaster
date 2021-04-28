package ch.zhaw.homework.le05a.task05_WiSiButton4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileIOstream {

    private String filePath;
    private String fileNametxt;

    public FileIOstream() {
        filePath = "/home/bonux/Desktop/tempToKill" + File.separator;
        fileNametxt = "testButton4.txt";
    }

    /**
     * create a new file contains the button 4 inputs
     *
     * @param **ArrayList<>()**
     */
    public void createFile(ArrayList<String> list) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath +fileNametxt))) {

            for (String string : list) {
                writer.write(string);
                writer.newLine();
            }
        }
        System.out.println("successfully wrote <text list> in to folder <txt>");
    }

    public ArrayList<String> getList() {

        Path file = Paths.get(filePath, fileNametxt);
        ArrayList<String> list = new ArrayList<>();

        try {
            List<String> allLines = Files.readAllLines(file, StandardCharsets.UTF_8);

            for (String line : allLines) {
                list.add(line);
            }
        }
        catch (IOException e) {e.printStackTrace();
        }
        return list;
    }

    /**
     * handles the path to the file
     * @return filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * give the file.ser given from Path
     * @return fileName
     */
    public String getFileName() {
        return fileNametxt;
    }
}
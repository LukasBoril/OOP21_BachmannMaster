package ch.zhaw.homework.le05;

import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileIOStrategy implements IOStrategy{

    private final FileSelector fileSelector = new FileSelector();

    @Override
    public void serialize(List<String> data) {

        Path savefile = Paths.get(fileSelector.saveFile(new Stage()).toString() + ".txt");

        try (BufferedWriter writer = Files.newBufferedWriter(savefile, StandardCharsets.UTF_8)){
            for (String s : data){
                writer.write(s);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> deserialize() {

        Path loadFile = Paths.get(fileSelector.loadFile(new Stage()).toString());

        try {
            return Files.readAllLines(loadFile, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}

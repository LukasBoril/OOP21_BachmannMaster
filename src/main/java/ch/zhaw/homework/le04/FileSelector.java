package ch.zhaw.homework.le04;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import java.io.File;

public class FileSelector {

    private final ExtensionFilter[] extensionFilters = {
            new ExtensionFilter("Text Dateien", ".txt"),
            new ExtensionFilter("HTML Dateien", ".html"),
            new ExtensionFilter("XML Dateien", ".xml"),
            new ExtensionFilter("Serialisierte Objekt Dateien", ".ser")
    };

    public File loadFile(Stage stage){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Wähle Datei");
        fileChooser.getExtensionFilters().addAll(extensionFilters);

        return fileChooser.showOpenDialog(stage);
    }

    public File saveFile(Stage stage){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Speichere Datei");
        fileChooser.getExtensionFilters().addAll(extensionFilters);

        return fileChooser.showSaveDialog(stage);
    }
}

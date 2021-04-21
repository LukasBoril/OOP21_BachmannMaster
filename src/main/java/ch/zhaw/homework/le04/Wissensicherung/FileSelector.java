package ch.zhaw.homework.le04.Wissensicherung;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class FileSelector {
    // Extension Filter
    private ExtensionFilter[] extensionfilter = {
            new ExtensionFilter("Text Dateien", "*.txt"),
            new ExtensionFilter("HTML Dateien", "*.html"),
            new ExtensionFilter("XML Dateien", "*.xml"),
            new ExtensionFilter("Serialisierte Objekt Dateien", "*.ser")
    };
    /**
     * File Chooser loadFile
     *
     * @param stage
     * @return boolean chosen file
     */
    public File loadFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");
        fileChooser.getExtensionFilters().addAll(extensionfilter);
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            return selectedFile;
        }
        return null;
    }
    /**
     * File chooser saveFile
     *
     * @param stage
     * @return boolean chosen file
     */
    public File saveFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save file");
        fileChooser.getExtensionFilters().addAll(extensionfilter);
        File selectedFile = fileChooser.showSaveDialog(stage);
        if (selectedFile != null) {
            return selectedFile;
        }
        return null;
    }
}

package ch.zhaw.homework.le05.Entscheidungsknopf5b;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class ObjectStreamStrategy {
    /**
     * Deserialize the data from the file
     */
    public ArrayList<String> loadDecision(Stage stage) {
        try {

            File file = chooseLoadFile(new File(createFileName()), stage);
            if (file != null) {
                ArrayList<String> out = deserialize(file);
                displayAlert(Alert.AlertType.CONFIRMATION, "'Was tun?' Liste von Datei " + file.getPath() + " geladen.");
                return out;
            }
            return null;

        } catch (IOException e) {
            displayAlert(Alert.AlertType.ERROR, e.getLocalizedMessage());
            return null;
        }
    }

    /**
     * Serialize the data to a file
     */
    public void saveDecision(Stage stage, Object o) {
        try {
            File file = chooseSaveFile(new File(createFileName()), stage);
            if (file != null) {
                serialize(o, file);
                displayAlert(Alert.AlertType.CONFIRMATION, "'Was tun?' Liste gespeichert in Datei " + file.getPath() + ".");
            }

        } catch (IOException e) {
            displayAlert(Alert.AlertType.ERROR, e.getLocalizedMessage());
        }
    }

    /**
     * Create file name for serialisation
     * @return the file name in the user home folder
     */
    private String createFileName () {
        return  System.getProperty("user.home") + System.getProperty("file.separator") + "decision.ser";
    }


    /**
     * Opens the load file chooser
     * @param file the initial file object displayed in the chooser
     * @param stage  the reference to the stage
     * @return a File object or null
     */

    private File chooseLoadFile (File file, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load Decision File");

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Serialized files (*.ser)", "*.ser");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setInitialDirectory(new File(file.getParent()));

        // Show open file dialog
        return fileChooser.showOpenDialog(stage);
    }

    /**
     * Serializes the ArrayList to a file
     * @param data the ArrayList to serialize
     * @param file the file object for serialisation
     * @throws IOException an IOExecetion if the serialisation is not successful
     */
    private void serialize(Object data, File file) throws IOException {

        try (OutputStream outStream = new FileOutputStream(file);
             ObjectOutputStream outObject = new ObjectOutputStream(outStream)) {

            outObject.writeObject(data);

        } catch (IOException e) {
            throw new IOException("Daten können nicht in der Datei " + file.getPath() + " gespeichert werden!");
        }
    }


    /**
     * Deserializes file to object
     * @param file to read from
     * @return deserialized ArrayList
     * @throws IOException if file is not found or if unable to deserialize data
     */
    @SuppressWarnings("unchecked")
    private ArrayList<String> deserialize(File file) throws IOException {

        try (InputStream inStream = new FileInputStream(file);
             ObjectInputStream inObject = new ObjectInputStream(inStream)) {

            return (ArrayList<String>) inObject.readObject();

        } catch (ClassNotFoundException | IOException e) {
            throw new IOException("Die Daten können nicht von der Datei " + file.getPath() + " gelesen werden");

        }
    }

    /**
     * Opens the save file chooser
     * @param file the initial file name and path displayed in the chooser
     * @param stage the reference to the stage
     * @return a File object or null
     */
    private File chooseSaveFile (File file, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Decision File");
        fileChooser.setInitialDirectory(new File(file.getParent()));
        fileChooser.setInitialFileName(file.getName());

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Serialized files (*.ser)", "*.ser");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show open file dialog
        return fileChooser.showSaveDialog(stage);

    }

    private Optional<ButtonType> displayAlert(Alert.AlertType type, String alertText) {
        Alert alert = new Alert(type);
        alert.setTitle("Decision Button");
        alert.setHeaderText(alertText);
        return alert.showAndWait();
    }

}

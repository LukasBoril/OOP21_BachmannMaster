package ch.zhaw.homework.le05.v4.presentation;


import ch.zhaw.homework.le05.v4.domain.AddOperationResult;
import ch.zhaw.homework.le05.v4.domain.DecisionData;
import ch.zhaw.homework.le05.v4.persistence.FileIOStrategy;
import ch.zhaw.homework.le05.v4.persistence.ObjectStreamStrategy;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Entscheidungsknopf mit Serialisierung und Deserialisierung
 * Überprüfung doppelte Einträge
 * Überprüfung leerer Eintrag
 */

public class DecisionButtonPresentation extends Application {

    private final Label labelAmount = new Label("[0]");
    private DecisionData decisionData;


    @Override
    public void start(Stage primaryStage) {
        decisionData = new DecisionData();

        BorderPane root = new BorderPane();
        root.setTop(createMenuPane(primaryStage));
        root.setCenter(createCenterPane());
        root.setBottom(createBottomPane());

        Scene scene = new Scene(root, 500, 250);

        primaryStage.setTitle("Entscheidungsknopf 4");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * program entry point
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        System.setProperty("prism.lcdtext", "false");
        launch(args);
    }


    /**
     * Create the menu bar with one menu
     *
     * @return the menu bar
     */
    private Node createMenuPane(Stage stage) {

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("_Datei");
        menuFile.setMnemonicParsing(true);

        MenuItem menuOpen = createMenuItem("Entscheidungen _laden", event -> loadDecision(stage), KeyCode.O, KeyCombination.CONTROL_DOWN);
        MenuItem menuSave = createMenuItem("Entscheidungen _speichern", event -> saveDecision(stage), KeyCode.S, KeyCombination.CONTROL_DOWN);
        MenuItem menuExit = createMenuItem("_Beenden", event -> exitDecision(), KeyCode.F4, KeyCombination.ALT_DOWN);


        Menu menuStrategy = new Menu("_Strategy");
        ToggleGroup toggleGroup = new ToggleGroup();

        RadioMenuItem radioItemObject = new RadioMenuItem("Object");
        radioItemObject.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                decisionData.setIOStrategy(new ObjectStreamStrategy());
            }
        });
        radioItemObject.setToggleGroup(toggleGroup);

        RadioMenuItem radioItemFile = new RadioMenuItem("File");
        radioItemFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                decisionData.setIOStrategy(new FileIOStrategy());
            }
        });
        radioItemFile.setToggleGroup(toggleGroup);

        menuStrategy.getItems().addAll(radioItemObject, radioItemFile);
        radioItemObject.setSelected(true);

        menuFile.getItems().addAll(menuOpen, menuSave, menuExit);
        menuBar.getMenus().addAll(menuFile, menuStrategy);
        return menuBar;
    }

    /**
     * creates the label in the top pane
     *
     * @return the top pane as a hbox
     */
    private Pane createInputPane() {

        final Label labelProposal = new Label("Was tun?:");
        final TextField textProposal = new TextField();
        final Button buttonProposal = new Button("Hinzufügen");

        EventHandler<ActionEvent> onTextEnter = event -> {

            AddOperationResult addOperationResult = decisionData.addDecision(textProposal.getText());
            if (addOperationResult.hasError()) {
                displayAlert(Alert.AlertType.ERROR, addOperationResult.getMessage());
            }
            updateAmount();
        };

        buttonProposal.setOnAction(onTextEnter);
        textProposal.setOnAction(onTextEnter);

        HBox.setHgrow(textProposal, Priority.ALWAYS);

        HBox hbox = new HBox(10, createSpacer(), labelProposal, textProposal, labelAmount, buttonProposal, createSpacer());
        hbox.setPadding(new Insets(7, 7, 7, 7));

        return hbox;

    }

    /**
     * creates a growable Button in the center pane
     *
     * @return the center pane as a hbox
     */
    private Pane createCenterPane() {
        Button button = new Button("Klick mich");
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setOnAction(event -> {
            if (decisionData.getRandomDecision().isEmpty()) displayAlert(Alert.AlertType.INFORMATION, "Noch keine 'Was tun?' Einträge");
            else button.setText(decisionData.getRandomDecision());
        });

        HBox boxCenter = new HBox(10, createSpacer(), button, createSpacer());
        boxCenter.setAlignment(Pos.CENTER);
        HBox.setHgrow(button, Priority.ALWAYS);

        VBox vbox = new VBox(createInputPane(), boxCenter);
        vbox.setPadding(new Insets(7, 7, 7, 7));
        VBox.setVgrow(boxCenter, Priority.ALWAYS);
        return vbox;

    }

    /**
     * creates a Label in the bottom pane
     *
     * @return a Pane with Hbox
     */
    private Pane createBottomPane() {
        Label l = new Label();
        return new HBox(l);
    }

    /**
     * Display an Alert Box
     *
     * @param alertText the text to display
     */
    private Optional<ButtonType> displayAlert(Alert.AlertType type, String alertText) {
        Alert alert = new Alert(type);
        alert.setTitle("Decision Button");
        alert.setHeaderText(alertText);
        return alert.showAndWait();
    }

    /**
     * Create a Menu Item with an Accelerator
     *
     * @param menuText  the text of the menu
     * @param code      the accelerator Code e.g. KeyCode.X
     * @param modifiers the modifier e.g. KeyCombination.CONTROL_DOWN
     * @return the MenuItem
     */
    private MenuItem createMenuItem(String menuText, EventHandler<ActionEvent> value, KeyCode code, KeyCombination.Modifier... modifiers) {
        MenuItem item = new MenuItem(menuText);
        item.setAccelerator(new KeyCodeCombination(code, modifiers));
        item.setOnAction(value);
        return item;
    }

    /**
     * Create Spacer Rect
     *
     * @return a space rectangle
     */
    private Rectangle createSpacer() {
        Rectangle rect = new Rectangle(15, 20);
        rect.setFill(Color.TRANSPARENT);
        return rect;
    }

    /**
     * Updates the amount of entries in values
     */
    private void updateAmount() {

        labelAmount.setText("[" + decisionData.getCount() + "]");

        String style = labelAmount.getStyle();
        labelAmount.setStyle("-fx-background-color: rgb(119, 192, 75, .9)");
        PauseTransition wait = new PauseTransition(Duration.seconds(1));
        wait.setOnFinished(event -> labelAmount.setStyle(style));
        wait.play();
    }

    /**
     * Return random values (proposals)
     *
     * @return a random proposal
     */
    private String getRandomText() {

        return decisionData.getRandomDecision();

    }


    /**
     * Deserialize the data from the file
     */
    private void loadDecision(Stage stage) {
        try {

            File file = chooseLoadFile(new File(createFileName()), stage);
            if (file != null) {
                //values = deserialize(file);
                decisionData.loadDecisions(file);
                updateAmount();
                displayAlert(Alert.AlertType.CONFIRMATION, "'Was tun?' Liste von Datei " + file.getPath() + " geladen.");
            }

        } catch (IOException | ClassNotFoundException e) {
            displayAlert(Alert.AlertType.ERROR, e.getLocalizedMessage());
        }
    }

    /**
     * Serialize the data to a file
     */
    private void saveDecision(Stage stage) {
        try {
            File file = chooseSaveFile(new File(createFileName()), stage);
            if (file != null) {
                decisionData.saveDecisions(file);
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
        if(decisionData.getIOStrategy() instanceof ObjectStreamStrategy) {
            return  System.getProperty("user.home") + System.getProperty("file.separator") + "decision.ser";
        } else  {
            return  System.getProperty("user.home") + System.getProperty("file.separator") + "decision.txt";
        }

    }

    /**
     * Exit the application
     */
    private void exitDecision() {
        Optional<ButtonType> result = displayAlert(Alert.AlertType.CONFIRMATION, "Decision Button verlassen?");
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.exit(0);
        }
    }

    /**
     * Initialize values for random proposals
     *
     * @return random action values
     */
    private ArrayList<String> initValues() {

        return new ArrayList<>();

    }

    /**
     * Serializes the ArrayList to a file
     * @param data the ArrayList to serialize
     * @param file the file object for serialisation
     * @throws IOException an IOExecetion if the serialisation is not successful
     */
    private void serialize(ArrayList<String> data, File file) throws IOException {

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
        FileChooser.ExtensionFilter extFilter;
        if(decisionData.getIOStrategy() instanceof ObjectStreamStrategy) {
            extFilter = new FileChooser.ExtensionFilter("Serialized files (*.ser)", "*.ser");
        } else {
            extFilter = new FileChooser.ExtensionFilter("Serialized files (*.txt)", "*.txt");
        }

		fileChooser.getExtensionFilters().add(extFilter);

		// Show open file dialog
		return fileChooser.showSaveDialog(stage);

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
        FileChooser.ExtensionFilter extFilter;
        if(decisionData.getIOStrategy() instanceof ObjectStreamStrategy) {
            extFilter = new FileChooser.ExtensionFilter("Serialized files (*.ser)", "*.ser");
        } else {
            extFilter = new FileChooser.ExtensionFilter("Serialized files (*.txt)", "*.txt");
        }
		fileChooser.getExtensionFilters().add(extFilter);
		fileChooser.setInitialDirectory(new File(file.getParent()));

		// Show open file dialog
		return fileChooser.showOpenDialog(stage);
    }

}

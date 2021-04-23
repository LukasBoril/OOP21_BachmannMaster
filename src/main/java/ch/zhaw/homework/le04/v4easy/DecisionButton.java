package ch.zhaw.homework.le04.v4easy;


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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Optional;

/**
 * Entscheidungsknopf mit Serialisierung und Deserialisierung
 * Überprüfung doppelte Einträge
 * Überprüfung leerer Eintrag
 */

public class DecisionButton extends Application {

    private final Label labelAmount = new Label("[0]");
    private DecisionData decisionData;


    @Override
    public void start(Stage primaryStage) {

        decisionData = new DecisionData();

        BorderPane root = new BorderPane();
        root.setTop(createMenuPane());
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
    private Node createMenuPane() {

        MenuBar menuBar = new MenuBar();

        // the file menu
        Menu menuFile = new Menu("_Datei");
        menuFile.setMnemonicParsing(true);

        MenuItem menuOpen = createMenuItem("Entscheidungen _laden", event -> loadDecision(), KeyCode.O, KeyCombination.CONTROL_DOWN);
        MenuItem menuSave = createMenuItem("Entscheidungen _speichern", event -> saveDecision(), KeyCode.S, KeyCombination.CONTROL_DOWN);
        MenuItem menuExit = createMenuItem("_Beenden", event -> exitDecision(), KeyCode.F4, KeyCombination.ALT_DOWN);

        // the strategy menu
        Menu menuStrategy = new Menu("_Strategy");
        menuStrategy.setMnemonicParsing(true);

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioMenuItem radioMenuObjectStream = createMenuItem("_Object Stream IO", event -> decisionData.setIOStrategy(new ObjectStreamStrategy()), toggleGroup, true);
        RadioMenuItem radioMenuFileStream = createMenuItem("_File Stream IO", event -> decisionData.setIOStrategy(new FileIOStrategy()), toggleGroup, false);

        // add menu items to menu
        menuFile.getItems().addAll(menuOpen, menuSave, menuExit);
        menuStrategy.getItems().addAll(radioMenuObjectStream, radioMenuFileStream);
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

            if (textProposal.getText().isEmpty()) {
                displayAlert(Alert.AlertType.INFORMATION, "Bitte Text eingeben!");
            } else {
                if (decisionData.contains(textProposal.getText())) {
                    displayAlert(Alert.AlertType.INFORMATION, "Der Eintrag " + textProposal.getText() + " existiert bereits");
                } else {
                    decisionData.add(textProposal.getText());
                    textProposal.clear();
                }
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
            if (decisionData.isEmpty()) displayAlert(Alert.AlertType.INFORMATION, "Noch keine 'Was tun?' Einträge");
            else button.setText(decisionData.getRandomText());
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
     * @param value the event handler call back
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
     * Create a radio menu item and add it to toggle group
     *
     * @param menuText the text of the menu
     * @param value the event handler call back
     * @param toggleGroup the toggle group to add the radio item
     * @param selected shall the menu be selected
     * @return the RadioMenuItem
     */
    private RadioMenuItem createMenuItem(String menuText, EventHandler<ActionEvent> value, ToggleGroup toggleGroup , boolean selected) {
        RadioMenuItem item = new RadioMenuItem(menuText);
        item.setOnAction(value);
        item.setSelected(selected);
        item.setToggleGroup(toggleGroup);
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

        labelAmount.setText("[" + decisionData.getSize() + "]");

        String style = labelAmount.getStyle();
        labelAmount.setStyle("-fx-background-color: rgb(119, 192, 75, .9)");
        PauseTransition wait = new PauseTransition(Duration.seconds(1));
        wait.setOnFinished(event -> labelAmount.setStyle(style));
        wait.play();
    }

    /**
     * Deserialize the data from the file
     */
    private void loadDecision() {
        try {
            String fileName = createFileName();
            decisionData.loadDecisions(fileName);
            updateAmount();
            displayAlert(Alert.AlertType.CONFIRMATION, "'Was tun?' Liste von Datei " + fileName + " geladen.");
        } catch (IOException | ClassNotFoundException e) {
            displayAlert(Alert.AlertType.ERROR, e.getLocalizedMessage());
        }
    }

    /**
     * Serialize the data to a file
     */
    private void saveDecision() {
        try {
            String fileName = createFileName();
            decisionData.saveDecisions(fileName);
            displayAlert(Alert.AlertType.CONFIRMATION, "'Was tun?' Liste gespeichert in Datei " + fileName + ".");
        } catch (IOException e) {
            displayAlert(Alert.AlertType.ERROR, e.getLocalizedMessage());
        }
    }

    /**
     * Create file name for serialisation
     * @return the file name in the user home folder
     */
    private String createFileName () {
        return  System.getProperty("user.home") + System.getProperty("file.separator") +
                (decisionData.getIOStrategy() instanceof ObjectStreamStrategy ?  "decision.ser" : "decision.txt");
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


}

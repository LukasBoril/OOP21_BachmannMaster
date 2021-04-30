package ch.zhaw.homework.le05.Entscheidungsknopf5b;


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
import java.util.Random;

/**
 * Entscheidungsknopf mit Serialisierung und Deserialisierung
 * Überprüfung doppelte Einträge
 * Überprüfung leerer Eintrag
 */

public class EntscheidungsKnopf3 extends Application {

    private ArrayList<String> values;
    private final Random random = new Random();
    private final Label labelAmount = new Label("[0]");
    private FileIOStrategy strategy = new FileIOStrategy();



        @Override
    public void start(Stage primaryStage) {

        this.values = initValues();

        BorderPane root = new BorderPane();
        root.setTop(createMenuPane(primaryStage));
        root.setCenter(createCenterPane());
        root.setBottom(createBottomPane());

        Scene scene = new Scene(root, 500, 250);

        primaryStage.setTitle("Entscheidungsknopf 3");
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

        MenuItem menuOpen = createMenuItem("Entscheidungen _laden", new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                values = strategy.loadDecision(stage);
                updateAmount();
            }
        }, KeyCode.O, KeyCombination.CONTROL_DOWN);
        MenuItem menuSave = createMenuItem("Entscheidungen _speichern", event -> strategy.saveDecision(stage, values), KeyCode.S, KeyCombination.CONTROL_DOWN);
        MenuItem menuExit = createMenuItem("_Beenden", event -> exitDecision(), KeyCode.F4, KeyCombination.ALT_DOWN);

        menuFile.getItems().addAll(menuOpen, menuSave, menuExit);
        menuBar.getMenus().addAll(menuFile);
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
                if (values.contains(textProposal.getText())) {
                    displayAlert(Alert.AlertType.INFORMATION, "Der Eintrag " + textProposal.getText() + " existiert bereits");
                } else {
                    values.add(textProposal.getText());
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
            if (values.isEmpty()) displayAlert(Alert.AlertType.INFORMATION, "Noch keine 'Was tun?' Einträge");
            else button.setText(this.getRandomText());
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

        labelAmount.setText("[" + values.size() + "]");

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

        return values.get(random.nextInt(values.size()));

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



}

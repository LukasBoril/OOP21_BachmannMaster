package ch.zhaw.homework.le04;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Entscheidungsknopf mit Eingabe was zu tun wäre
 */

public class EntscheidungsKnopf4 extends Application {

    private ArrayList<String> values;
    private final Random random = new Random();


    @Override
    public void start(Stage primaryStage) {

        this.values = initValues();

        BorderPane root = new BorderPane();
        root.setTop(createMenu(primaryStage));
        root.setLeft(createTopPane());
        root.setCenter(createCenterPane());
        root.setBottom(createBottomPane());


        Scene scene = new Scene(root, 350, 250);

        primaryStage.setTitle("Entscheidungsknopf 2");
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

    public void saveToFile(Stage stage) {

        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {

            try (OutputStream fos = new FileOutputStream(file)) {
                values.forEach(word -> {
                    byte[] bytesArray = word.getBytes(StandardCharsets.UTF_8);

                    try {
                        fos.write(bytesArray);
                        fos.write(10);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                fos.flush();


            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    public void loadFile(Stage stage) {

        FileChooser fileChooser = new FileChooser();
        File fileToLoad = fileChooser.showOpenDialog(stage);
        if (fileToLoad != null) {
            try {
                FileReader fileReader = new FileReader(fileToLoad);
                BufferedReader in = new BufferedReader(fileReader);

                String str;
                while ((str = in.readLine()) != null) {

                    values.add(str);
                }
                in.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    /**
     * creates the label in the top pane
     *
     * @return the top pane as a hbox
     */
    private Pane createTopPane() {

        final Label labelProposal = new Label("Was tun?:");
        final Label labelAmount = new Label("[0]");
        final TextField textProposal = new TextField();
        final Button buttonProposal = new Button("Save");

        EventHandler<ActionEvent> onTextEnter = event -> {

            if (textProposal.getText().isEmpty()) {
                displayAlert("Bitte Text eingeben!");
            } else {
                if (values.contains(textProposal.getText())) {
                    displayAlert("Der Eintrag '" + textProposal.getText() + "' existiert bereits");
                } else {
                    values.add(textProposal.getText());
                    textProposal.clear();
                }
            }
            labelAmount.setText("[" + values.size() + "]");
        };

        buttonProposal.setOnAction(onTextEnter);
        textProposal.setOnAction(onTextEnter);

        HBox hbox = new HBox(10, labelProposal, textProposal, labelAmount, buttonProposal);
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
            if (values.isEmpty()) displayAlert("Noch keine 'Was tun?' Einträge");
            else button.setText(this.getRandomText());
        });

        Rectangle rectLeft = new Rectangle(30, 20);
        rectLeft.setFill(Color.TRANSPARENT);
        Rectangle rectRight = new Rectangle(30, 20);
        rectRight.setFill(Color.TRANSPARENT);

        HBox boxCenter = new HBox(10, rectLeft, button, rectRight);
        boxCenter.setAlignment(Pos.CENTER);
        HBox.setHgrow(button, Priority.ALWAYS);

        return boxCenter;
    }

    /**
     * creates a menu bar
     *
     * @return a menu bar
     */
    private MenuBar createMenu(Stage stage) {
        //create "Datei" menu
        Menu menu1 = new Menu("Datei");

        //create menu items
        MenuItem datei = new MenuItem("Entscheidungen laden");
        MenuItem datei1 = new MenuItem("Entscheidungen speichern");

        //adding menu items to menu
        menu1.getItems().addAll(datei, datei1);

        //set action for menu item datei1
        datei1.setOnAction((ActionEvent t) -> saveToFile(stage));

        //set action for menu item datei
        datei.setOnAction((ActionEvent t) -> loadFile(stage));

        //create menubar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu1);
        return menuBar;

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

    private void displayAlert(String alertText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Decision Button");
        alert.setHeaderText(alertText);
        alert.showAndWait();
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
     * Initialize values for random proposals
     *
     * @return random action values
     */
    private ArrayList<String> initValues() {

        return new ArrayList<>();

    }

}

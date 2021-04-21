package ch.zhaw.homework.le04.Wissensicherung;


import ch.zhaw.homework.le04.task3.Auto;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Entscheidungsknopf mit Eingabe was zu tun wäre
 */

public class EntscheidungsKnopfPN extends Application implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<String> values;
    private final Random random = new Random();
    transient private FileSelector fileSelector = new FileSelector();

    @Override
    public void start(Stage primaryStage) {

        this.values = initValues();

        // Create MenuBar
        MenuBar menuBar = new MenuBar();
        // Create menus
        Menu dateiMenu = new Menu("Datei");

        // Create MenuItems load
        MenuItem loadItem = new MenuItem("Entscheidungen laden");

        //load ser- file and fill the values
        loadItem.setOnAction( event -> {
            File file = fileSelector.loadFile(primaryStage);

            try (InputStream fis = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fis))   {

                EntscheidungsKnopfPN entscheidungsKnopfPN = (EntscheidungsKnopfPN) ois.readObject();
                this.values = entscheidungsKnopfPN.getValues();
                System.out.println("Liste:" + entscheidungsKnopfPN.getValues());


            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        // Create MenuItems save
        MenuItem saveItem = new MenuItem("Entscheidungen speichern");

        //save ser- file
        saveItem.setOnAction( event -> {
             File file = fileSelector.saveFile(primaryStage);

            try (OutputStream fos = new FileOutputStream(file);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                oos.writeObject(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        // Add menuItems to the Menus
        dateiMenu.getItems().addAll(loadItem, saveItem);


        // Add Menus to the MenuBar
        menuBar.getMenus().add(dateiMenu);

        //Create the whole Function
        BorderPane root = new BorderPane();
        root.setTop(createTopPane());
        root.setCenter(createCenterPane());
        root.setBottom(createBottomPane());

        //Merge the Menu and the Function
        VBox layout = new VBox(menuBar,root);

        Scene scene = new Scene(layout, 350, 250);

        primaryStage.setTitle("Entscheidungsknopf PN");
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
        //EntscheidungsKnopfPN entscheidungsKnopfPN = new EntscheidungsKnopfPN();
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

    public ArrayList<String> getValues() {
        return values;
    }
}
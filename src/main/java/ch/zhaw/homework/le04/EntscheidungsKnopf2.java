package ch.zhaw.homework.le04;


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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Entscheidungsknopf mit Eingabe was zu tun wäre
 */

public class EntscheidungsKnopf2 extends Application {

    private ArrayList<String> values;
    private final Random random = new Random();
    private Stage primaryStage;


    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.values = initValues();

        BorderPane root = new BorderPane();
        root.setTop(createTopPane());
        root.setCenter(createCenterPane());
        root.setBottom(createBottomPane());

//        final Menu menu1 = new Menu("Datei");
//        MenuItem laden = new MenuItem("Laden");
//        laden.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent t) {
//                System.out.println("Save");
//            }
//        });
//        MenuItem speichern = new MenuItem("Speichern");
//        speichern.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent t) {
//                FileChooser fileChooser = new FileChooser();
//                fileChooser.setTitle("Datei speichern");
//                File file = fileChooser.showSaveDialog(primaryStage);
//                if (!(file==null)) {
//                    try {
//                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//                        oos.writeObject(values);
//                        oos.close();
//                    }
//                    catch (IOException ex) {
//                        System.out.println("Saving did not work, sorry");
//                        System.out.println(ex.toString());
//                    }
//                }
//            }
//        });
//
//        menu1.getItems().addAll(laden,speichern);
//        MenuBar menuBar = new MenuBar();
//        menuBar.getMenus().addAll(menu1);


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

    /**
     * creates the label in the top pane
     *
     * @return the top pane as a hbox
     */
    private Pane createTopPane() {

        VBox vbox = new VBox();
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

        final Menu menu1 = new Menu("Datei");
        MenuItem laden = new MenuItem("Laden");
        laden.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter fileExtension = new FileChooser.ExtensionFilter("select your load file ", "*.ser");
                fileChooser.getExtensionFilters().add(fileExtension);
                File file= fileChooser.showOpenDialog(new Stage());

                if (!(file==null)) {
                    try {
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                        Object input = ois.readObject();
                        values = (ArrayList<String>) input;
                        ois.close();
                    }
                    catch (IOException ex) {
                        System.out.println("Saving did not work, sorry");
                        System.out.println(ex.toString());
                    }
                    catch (ClassNotFoundException ex) {
                        System.out.println("Saving did not work, sorry");
                        System.out.println(ex.toString());
                    }
                }
            }
        });
        MenuItem speichern = new MenuItem("Speichern");
        speichern.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Datei speichern");
                File file = fileChooser.showSaveDialog(primaryStage);
                if (!(file==null)) {
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(values);
                        oos.close();
                    }
                    catch (IOException ex) {
                        System.out.println("Saving did not work, sorry");
                        System.out.println(ex.toString());
                    }
                }
            }
        });

        menu1.getItems().addAll(laden,speichern);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu1);

        vbox.getChildren().addAll(menuBar, hbox);
        return vbox;

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

}

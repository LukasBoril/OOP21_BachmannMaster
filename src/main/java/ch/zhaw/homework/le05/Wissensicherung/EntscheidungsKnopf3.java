package ch.zhaw.homework.le05.Wissensicherung;


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

public class EntscheidungsKnopf3 extends Application {

    private ArrayList<String> values;
    private final Random random = new Random();


    @Override
    public void start(Stage primaryStage) {

        this.values = initValues();

        BorderPane root = new BorderPane();
        root.setTop(createTopPane());
        root.setCenter(createCenterPane());
        root.setBottom(createBottomPane());

        Scene scene = new Scene(root, 400, 250);

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
        final MenuItem loadMenu = new MenuItem("Vorschläge Laden");
        final MenuItem saveMenu = new MenuItem("Vorschläge speichern");
        final Menu menu1 = new Menu("Datei");
        menu1.getItems().addAll(loadMenu, saveMenu);
        final MenuBar menuBar = new MenuBar(menu1) ;


        final Label labelProposal = new Label("Was tun?:");
        final Label labelAmount = new Label("[0]");
        final TextField textProposal = new TextField();
        final Button buttonProposal = new Button("Save");
        final Button buttonDelete = new Button("Delete");

        loadMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               values =  unsserialize();
                labelAmount.setText("[" + values.size() + "]");
            }
        });

        saveMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                serialize(values);
            }
        });


        EventHandler<ActionEvent> onTextEnter = event -> {
            if (textProposal.getText().isEmpty()) {
                displayAlert("Bitte Text eingeben!");
            } else {
                if (event.getSource() == buttonProposal) {
                    if (values.contains(textProposal.getText())) {
                        displayAlert("Der Eintrag '" + textProposal.getText() + "' existiert bereits!");
                    } else {
                        values.add(textProposal.getText());
                        textProposal.clear();
                    }
                } else if (event.getSource() == buttonDelete) {
                    if (!values.contains(textProposal.getText())) {
                        displayAlert("Der Eintrag '" + textProposal.getText() + "' wurde nicht gefunden!");
                    } else {
                        values.remove(textProposal.getText());
                        /*Iterator<String> iter = values.iterator();
                        while (iter.hasNext()) {
                            iter.next();
                            values.remove(iter);
                        }*/
                    }
                }
            }
            labelAmount.setText("[" + values.size() + "]");
        };

        buttonProposal.setOnAction(onTextEnter);
        textProposal.setOnAction(onTextEnter);
        buttonDelete.setOnAction(onTextEnter);

        HBox hbox = new HBox(10,menuBar, labelProposal, textProposal, labelAmount, buttonProposal, buttonDelete);
        hbox.setPadding(new Insets(7, 7, 7, 7));
        VBox vBox = new VBox(menuBar, hbox);


        return vBox;

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

    public static void serialize(ArrayList<String> events) {
        try (OutputStream fos = new FileOutputStream("src/events.ser")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(events);
            System.out.println("Object serialisiert!");
            System.out.println("----------------------");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> unsserialize() {
        try (InputStream fis = new FileInputStream("src/events.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);

            System.out.println("Object deserialisiert:");
            System.out.println("----------------------");
            return (ArrayList<String>) ois.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}

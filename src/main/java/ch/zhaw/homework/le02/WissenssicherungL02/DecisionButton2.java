package ch.zhaw.homework.le02.WissenssicherungL02;

import ch.zhaw.homework.le01.WissenssicherungL01.AntwortMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;

public class DecisionButton2 extends Application {

        private ArrayList<String> randomText;
        private final Random ran = new Random();

        @Override
        public void start(Stage primaryStage) {

            this.randomText = initValues();


            BorderPane root = new BorderPane();
            root.setTop(createTopPane());
            root.setCenter(createCenterPane());
            root.setBottom(createBottomPane());

            Scene scene = new Scene(root,500, 240);

            primaryStage.setScene(scene);
            primaryStage.setTitle("DecisionButton1");
            primaryStage.show();
        }


        /**
         * put the entry point somewhere in the top
         * of the source file. its easier for the moment
         * @param args parameter not needed
         */
        public static void main(String[] args) {
            launch(args);   //no high-res. screens checked here
        }

        /**
         * create the top pane
         * put in a HBox and in this a text
         *
         * @return the created box whit all its content to the top Pain
         */
        private Node createTopPane() {
            final Label     whatsUp = new Label("whats up? Give your input -> ");
            final TextField inputField = new TextField();
            final Label     inputAmount = new Label("[0]");
            final Button    saveButton = new Button("Save");

            EventHandler<ActionEvent> keyStrocke = event -> {
                if(inputField.getText().isEmpty()) {
                    displayAlert("Please put in your text");
                }
                else {
                    if(randomText.contains(inputField.getText())) {
                        displayAlert("this entry " + inputField.getText() + " already exists");
                    } else {
                        randomText.add(inputField.getText());
                        inputField.clear();
                    }
                }
                inputAmount.setText("[" + randomText.size() + "]");
            };

            inputField.setOnAction(keyStrocke);
            saveButton.setOnAction(keyStrocke);

            HBox topBox = new HBox(10, whatsUp, inputField, inputAmount, saveButton);
            topBox.setPadding(new Insets(20, 0, 20, 0));
            topBox.setAlignment(Pos.CENTER);

            return topBox;
        }

    /**
         * create the centre box as HBox and a button in it.
         * The button needs the answer to the text in the top box
         * this text will change randomly after clicking the answer
         * @return the the created box whit a button
         */
        Pane createCenterPane() {
            Button button = new Button("Klick me");
            button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

            button.setOnAction(event -> {
                if (randomText.isEmpty()) {
                    displayAlert("No entries in 'whats up?' ");
                }
                else {
                    button.setText(this.getRandomText());
                }
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
     * empty Pain for spacing
     * @return bottomBox
     */
    private Node createBottomPane() {

            Label empty = new Label();  //just an empty box

            HBox bottomBox = new HBox(empty);
            bottomBox.setAlignment(Pos.CENTER);

            return bottomBox;
        }

    private void displayAlert(String alertString) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert on\n<DecisionButton2>");
        alert.setHeaderText(alertString);
        alert.showAndWait();

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
     * Get an answer out of the ArrayList <randomText>
     * @return String previous entered text
     */
    private String getRandomText() {
        return randomText.get(ran.nextInt(randomText.size()));

    }
}


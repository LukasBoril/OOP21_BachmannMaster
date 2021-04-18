package ch.zhaw.exercise.LE02;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Entscheidungsknopf extends Application {

    private ArrayList<String> values;
    private Random random = new Random();


    @Override
    public void start(Stage primaryStage) {

        this.values = initValues();


        BorderPane root = new BorderPane();
        root.setTop(createTopPane());
        root.setCenter(createCenterPane());
        root.setBottom(createBottomPane());

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Main Stage");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * program entry point
     *
     * @param args
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
    Pane createTopPane() {
        Label l1 = new Label("Was machen wir heute Abend?");
        l1.setPadding(new Insets(20, 10, 20, 0));


        HBox boxTop = new HBox(l1);
        boxTop.setAlignment(Pos.CENTER);

        return boxTop;
    }

    /**
     * creates a growable Button in the center pane
     *
     * @return the center pane as a hbox
     */
    Pane createCenterPane() {
        Button button = new Button("Klick mich");
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setOnAction(event -> button.setText(this.getRandomText()));

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
     * @return
     */
    Pane createBottomPane() {
        Label l = new Label();
        return new HBox(l);
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


        ArrayList<String> values = new ArrayList<String>();

        values.add("Ins Kino gehen");
        values.add("Essen gehen");
        values.add("Ins Theater gehen");
        values.add("Einen Eishockey Match schauen");
        values.add("Vor dem TV einschlafen");
        values.add("JavaFX programmieren");
        return values;

    }


}

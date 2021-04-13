package ch.zhaw.homework.le01.wissenssicherung;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class EntscheidungsKnopf extends Application {
    ArrayList<String> ausgehMoegichkeit;

    public EntscheidungsKnopf() {
        ausgehMoegichkeit = new ArrayList<>();
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        fillList();

        StackPane myStackPane = new StackPane();
        myStackPane.setMinSize(500,200);
        Button myButton = new Button("Klick mich!");
        myButton.setPrefSize(500,200);

        myButton.setOnAction(event -> myButton.setText(getRandomText()));

        myStackPane.getChildren().add(myButton);

        Scene myScene = new Scene(myStackPane);

        primaryStage.setScene(myScene);
        primaryStage.setTitle("Entscheidungsknopf");
        primaryStage.show();

    }

    public String getRandomText() {
        Random random = new Random();
        int randomNo = random.nextInt(ausgehMoegichkeit.size());
        return ausgehMoegichkeit.get(randomNo);
    }

    public void fillList() {
        ausgehMoegichkeit.add("Kino");
        ausgehMoegichkeit.add("Pizzeria");
        ausgehMoegichkeit.add("Santisbahn");
        ausgehMoegichkeit.add("Mollies");
        ausgehMoegichkeit.add("zu Kollegen");
        ausgehMoegichkeit.add("Nachbarn");
    }


}

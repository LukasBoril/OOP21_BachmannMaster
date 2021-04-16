package ch.zhaw.homework.le01;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DecisionButton extends Application {
    List<String> possibilities;
    Random generator;

    public DecisionButton() {
        possibilities = Arrays.asList("Essen gehen", "Kino", "Konzert");
        generator = new Random();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        var mainPane = new StackPane();
        var mainButton = new Button("Click me");
        var scene = new Scene(mainPane);

        mainPane.setMinSize(500, 200);
        mainButton.setPrefSize(300, 100);
        mainButton.setOnAction(event -> mainButton.setText(getPossibility()));

        mainPane.getChildren().add(mainButton);

        stage.setScene(scene);
        stage.setTitle("Decision Button");
        stage.show();
    }

    public String getPossibility() {
        return possibilities.get(
                generator.nextInt(possibilities.size())
        );
    }
}

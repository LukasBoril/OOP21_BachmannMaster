package ch.zhaw.exercise.LE01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Entscheidungsknopf extends Application {
    String[] answers = {"Kino", "Essen", "Chillen", "Konzert", "Yoga"};
    Stage fenster;
    Scene szene1, szene2;
    Button button1, button2;
    private Random r = new Random();
    //Label label1, label2;

    @Override
    public void start(Stage primaryStage) {

        fenster = primaryStage;
        button1 = new Button("Klick mich!");
        button2 = new Button();
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fenster.setScene(szene2);
                fenster.show();
                button2.setText(generateRandomAnswer());
            }
        });
        StackPane layout1 = new StackPane();
        layout1.getChildren().add(button1);
        layout1.setAlignment(Pos.CENTER);
        szene1 = new Scene(layout1, 500, 500);

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fenster.setScene(szene1);
                fenster.show();
                button1.setText(generateRandomAnswer());
            }
        });
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        layout2.setAlignment(Pos.CENTER);
        szene2 = new Scene(layout2, 500, 500);
        primaryStage.setScene(szene1);
        primaryStage.show();
    }


    public String generateRandomAnswer(){
        return answers[r.nextInt(answers.length)];
    }

    public static void main(String[] args) {
        launch(args);
    }


}

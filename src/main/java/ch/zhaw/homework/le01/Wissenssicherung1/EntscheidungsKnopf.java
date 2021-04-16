package ch.zhaw.homework.le01.Wissenssicherung1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class EntscheidungsKnopf extends Application {

    private Random ran;
    private ArrayList<String> answers;

    public EntscheidungsKnopf()
    {
        ran = new Random();
        answers = new ArrayList<>();
        answers.add("Kino");
        answers.add("Konzert");
        answers.add("Essen gehen");
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Entscheidungsknopf");
        Button btn = new Button();
        btn.setText("Klick mich'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                btn.setText(getRandomTaskString());
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    private String getRandomTaskString()
    {
        int random = ran.nextInt(answers.size());
        return answers.get(random);
    }

    public static void main(String[] args) {
        launch();
    }
}

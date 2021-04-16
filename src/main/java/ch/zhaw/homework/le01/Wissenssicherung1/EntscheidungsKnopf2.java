package ch.zhaw.homework.le01.Wissenssicherung1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class EntscheidungsKnopf2 extends Application {

    private Random ran;
    private ArrayList<String> answers;

    public EntscheidungsKnopf2()
    {
        ran = new Random();
        answers = new ArrayList<>();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Entscheidungsknopf");
        VBox root = new VBox();
        Label label1 = new Label("Optionen für Aktivitäten:");
        TextField textField = new TextField ();

        Button btn_save = new Button();
        btn_save.setText("save");
        btn_save.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String input = textField.getText();
                answers.add(input);
                textField.setText("Enter next activity");
            }
        });

        Button btn = new Button();
        btn.setText("Klick mich'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                btn.setText(getRandomTaskString());
            }
        });


        root.getChildren().addAll(label1, textField);
        root.getChildren().add(btn_save);
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

package ch.zhaw.exercise.LE01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Entscheidungsknopf2 extends Application {
    ArrayList<String> answers;
    Stage fenster;
    Scene szene1;
    Button button1, button2;
    TextField textField;
    private Random r = new Random();
    //Label label1, label2;

    @Override
    public void start(Stage primaryStage) {

        initArrayList();

        fenster = primaryStage;

        BorderPane layout1 = new BorderPane();

        szene1 = new Scene(layout1, 500, 500);

        //Text und add im oberen Bildschirmteil



        layout1.setTop(setTopBox());



        button1 = setButton1();
        //layout1.getChildren().add(button1);
        layout1.setCenter(button1);




        fenster.show();
        fenster.setScene(szene1);



    }

    public HBox setTopBox(){
        HBox box = new HBox(10);
        textField = new TextField();
        button2 = new Button("add");
        final Label labelAmount = new Label("[0]");
        box.getChildren().addAll(textField, button2, labelAmount);


        EventHandler<ActionEvent> onTextEnter = event -> {

            if (textField.getText().isEmpty()) {
                System.out.println("Bitte Text eingeben!");
            } else {
                if (answers.contains(textField.getText())) {
                    System.out.println("Der Eintrag '" + textField.getText() + "' existiert bereits");
                } else {
                    answers.add(textField.getText());
                    textField.clear();
                }
            }
            labelAmount.setText("[" + answers.size() + "]");
        };

        button2.setOnAction(onTextEnter);
        textField.setOnAction(onTextEnter);

        return box;
    }

    public Button setButton1() {
        Button button = new Button("Klick mich!");
        button.setOnAction(event -> button.setText(generateRandomAnswer()));
        return button;
    }

    public String generateRandomAnswer(){
        return answers.get(r.nextInt(answers.size()));
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void initArrayList(){
        answers = new ArrayList<>();
        answers.add("first");
        answers.add("second");
    }

    public void addToAnswers(String entry){
        answers.add(entry);
    }

}

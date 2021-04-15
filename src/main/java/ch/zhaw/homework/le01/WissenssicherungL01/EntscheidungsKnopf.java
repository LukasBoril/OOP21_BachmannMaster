package ch.zhaw.homework.le01.WissenssicherungL01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EntscheidungsKnopf extends Application {

    private Stage fenster;
    private Scene szene1, szene2;
    private Button button1, button2;
    private Label label1, label2;
    private AntwortMap  antwort;

    /*public EntscheidungsKnopf() {
        start();
    }*/

    @Override
    public void start(Stage primaryStage) {
        try {
            antwort = new AntwortMap();
            fenster = primaryStage;
            label1 = new Label("Was machen wir heute Abend?");
            button1 = new Button(antwort.standardantwortAuswählen());

            // ActionHandler registrieren use lambda
            button1.setOnAction(event -> {fenster.setScene(szene2); fenster.show();});

            VBox layout1 = new VBox(30);
            layout1.getChildren().addAll(label1, button1);

            szene1 = new Scene(layout1, 250, 250);
            label2 = new Label("Das ist der zweite Abend, und heute?");
            button2 = new Button(antwort.standardantwortAuswählen());

            // ActionHandler registrieren use lambda
            button2.setOnAction(event -> {fenster.setScene(szene1); fenster.show();});

            VBox layout2 = new VBox(30);
            layout2.getChildren().addAll(label2, button2);

            szene2 = new Scene(layout2, 250, 250);
            primaryStage.setScene(szene1);
            primaryStage.show();
        }

        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

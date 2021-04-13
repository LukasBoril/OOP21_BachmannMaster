package ch.zhaw.homework.le01.Task5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ActivateScenes extends Application {
    Stage fenster;
    Scene szene1, szene2;
    Button button1,button2;
    Label label1, label2;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            fenster = primaryStage;

            //erste Szene
            label1 = new Label("Das ist die erste Szene");
            button1 = new Button("Zur zweiten Szene wechseln");
            button1.setOnAction(event -> {
                fenster.setScene(szene2);
                fenster.show();
            });

            VBox layout1 = new VBox(30);
            layout1.setMinSize(200,100);
            layout1.getChildren().addAll(label1,button1);
            szene1 = new Scene(layout1);

            //2te Szene
            label2 = new Label("Das ist die zweite Scene");
            button2 = new Button("Zur ersten Szene wechseln");
            button2.setOnAction(event -> {
                fenster.setScene(szene1);
                fenster.show();
            });
            VBox layout2 = new VBox(10);
            layout2.setMinSize(200,100);
            layout2.getChildren().addAll(label2,button2);
            szene2 = new Scene(layout2);

            primaryStage.setScene(szene1);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}

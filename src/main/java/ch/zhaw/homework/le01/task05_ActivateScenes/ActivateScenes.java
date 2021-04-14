package ch.zhaw.homework.le01.task05_ActivateScenes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ActivateScenes extends Application  {
    private Stage fenster;
    private Scene szene1, szene2;
    private Button button1, button2;
    private Label label1, label2;

    @Override
    public void start(Stage primaryStage) {
        try {
            fenster = primaryStage;
            label1 = new Label("Das ist die erste Szene");
            button1 = new Button("Zur zweiten Szene wechslen");
            button1.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    fenster.setScene(szene2);
                    fenster.show();
                }
            });

            VBox layout1 = new VBox(30);
            layout1.getChildren().addAll(label1, button1);
            szene1 = new Scene(layout1, 250, 250);
            label2 = new Label("Das ist die zweite Szene");
            button2 = new Button("Zur ersten Szene wechslen");
            //button2.setOnAction(new EventHandler<ActionEvent>() { //solved with a lambda
            // ActionHandler registrieren use lambda
            button2.setOnAction(event -> {fenster.setScene(szene1); fenster.show();});

            /*implement a lambda as learned in task03
            @Override
            public void handle(ActionEvent event) {
                   fenster.setScene(szene1);
                   fenster.show();
                }
            }); */

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

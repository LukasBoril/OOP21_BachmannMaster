package ch.zhaw.exercise.le01.task05;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ActivateScenes extends Application {

    private Stage window;
    private Scene scene1, scene2;
    private Button button1, button2;
    private Label label1, label2;

    @Override
    public void start(Stage primaryStage){
        try{
            window = primaryStage;
            label1 = new Label("Das ist die erste Szene");
            button1 = new Button("Zur zweiten Szene wechseln");
            button1.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    window.setScene(scene2);
                    window.show();
                }
            });

            VBox layout1 = new VBox(30);
            layout1.getChildren().addAll(label1, button1);
            scene1 = new Scene(layout1, 250, 250);

            label2 = new Label("Das ist die zweite Szene");
            button2 = new Button("Zur ersten Szene wechseln");
            button2.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    window.setScene(scene1);
                    window.show();
                }
            });

            VBox layout2 = new VBox(30);
            layout2.getChildren().addAll(label2, button2);
            scene2 = new Scene(layout2, 250, 250);

            primaryStage.setScene(scene1);
            primaryStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        launch(args);
    }

}

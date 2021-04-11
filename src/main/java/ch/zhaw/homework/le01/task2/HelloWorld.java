package ch.zhaw.homework.le01.task2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label hello = new Label("Hello");
        Label world = new Label("World");

        VBox root = new VBox();
        root.getChildren().add(hello);
        root.getChildren().add(world);

        Scene scene = new Scene(root, 240, 40);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

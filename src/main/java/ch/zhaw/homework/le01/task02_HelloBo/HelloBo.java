package ch.zhaw.homework.le01.task02_HelloBo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloBo extends Application {

    Stage primaryStage = new Stage();

    public HelloBo() {
        //start(primaryStage);
    }

    public void start(Stage primaryStage) {
        Label l1 = new Label("Hallo");
        Label l2 = new Label("*bo*");
        VBox root = new VBox();
        root.getChildren().add(l1);
        root.getChildren().add(l2);
        Scene scene = new Scene(root, 240, 40);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello user");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

package ch.zhaw.exercises.le01;

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

public class HelloWorld extends Application {
    public void start(Stage primaryStage) {
        Label l1 = new Label("Hallo");
        Label l2 = new Label("Welt");
        VBox root = new VBox();
       // root.getChildren().add(l1);
       // root.getChildren().add(l2);
       root.getChildren().add(createButton());

        Scene scene = new Scene(root, 240, 40);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World");
        primaryStage.show();

    }

    Pane createButton() {
        final Button btn = new Button();
        btn.setText("Add 'Hello World' Label");
        final FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(7, 7, 7, 7));
        pane.getChildren().add(btn);

// ActionHandler registrieren
        btn.setOnAction(event -> pane.getChildren().add(new Label("- Hello World! -")));

        return pane;
    }



    private Pane createToolbarPane() {
        final HBox hbox = new HBox(5);
        hbox.setStyle("-fx-border-width: 2;-fx-border-color: red;");
        hbox.getChildren().addAll(
                new Text("TOP"), new Button("HBox1"), new Button("HBox2"));
        return hbox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
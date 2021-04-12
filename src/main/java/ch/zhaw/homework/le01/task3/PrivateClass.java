package ch.zhaw.homework.le01.task3;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrivateClass extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label hello = new Label("Hello");
        Label world = new Label("World");

        VBox root = new VBox();
        root.getChildren().addAll(hello, world, createButton());

        Scene scene = new Scene(root, 240, 140);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }

    private Pane createButton() {
        final Button button = new Button("Add Hello World Label");

        final FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(7, 7, 7, 7));
        pane.getChildren().add(button);

        button.setOnAction(new MyEventHandler(pane));

        return pane;
    }

    private static class MyEventHandler implements EventHandler {

        private final Pane pane;

        private MyEventHandler(FlowPane pane) {
            this.pane = pane;
        }

        @Override
        public void handle(Event event) {
            Label newLabel = new Label("- Hello World! -");
            pane.getChildren().add(newLabel);
        }
    }
}
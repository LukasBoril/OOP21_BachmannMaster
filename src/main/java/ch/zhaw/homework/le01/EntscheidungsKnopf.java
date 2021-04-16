package ch.zhaw.homework.le01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EntscheidungsKnopf extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        final int BORDER_PANE_PADDING = 7;
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(BORDER_PANE_PADDING, BORDER_PANE_PADDING, BORDER_PANE_PADDING, BORDER_PANE_PADDING));
        borderPane.setCenter(createButton());

        primaryStage.setScene(new Scene(borderPane, 300, 100));
        primaryStage.setTitle("Decision Button");
        primaryStage.show();
    }

    private Pane createButton() {
        final Button btn = new Button("Click here");
        final FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(7, 7, 7, 7));
        pane.getChildren().add(btn);
        // register action handler for button
        btn.setOnAction(event -> {
            pane.getChildren().add(new Label("Some text"));
            System.out.println("Some console output.");
        });

        return pane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

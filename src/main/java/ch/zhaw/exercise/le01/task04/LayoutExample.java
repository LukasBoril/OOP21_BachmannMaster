package ch.zhaw.exercise.le01.task04;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LayoutExample extends Application {
    public void start(Stage primaryStage) {
        VBox root = new VBox();

        // createSimpleDialog(root);
        createLayoutDialog(root);

        Scene scene = new Scene(root, 240, 240);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }

    private void createLayoutDialog(VBox root) {
        final int BORDER_PANE_PADDING = 7;
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(BORDER_PANE_PADDING, BORDER_PANE_PADDING, BORDER_PANE_PADDING, BORDER_PANE_PADDING));
        borderPane.setTop(createToolbarPane());
        borderPane.setLeft(createNavigationPane());
        borderPane.setCenter(createInputPane());

        //root.getChildren().add();
    }

    private Pane createToolbarPane() {
        final int HBOX_SPACING = 5;
        HBox hBox = new HBox(HBOX_SPACING);
        return hBox;
    }

    private Pane createInputPane() {
        FlowPane pane = new FlowPane();

        return pane;
    }

    private Pane createNavigationPane() {
        FlowPane pane = new FlowPane();

        return pane;
    }

    private void createSimpleDialog(VBox root) {
        Label label1 = new Label("Hello");
        Label label2 = new Label("World");

        root.getChildren().add(label1);
        root.getChildren().add(label2);
        root.getChildren().add(createButton());
    }

    private Pane createButton() {
        final Button btn = new Button();
        btn.setText("Add 'Hello World' Label");
        final FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(7, 7, 7, 7));
        pane.getChildren().add(btn);
        // register action handler for button
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().add(new Label("- Hello World! -"));
            }
        });
        /* register event handler using lambda expressions
        btn.setOnAction(event -> pane.getChildren().add(new Label("- Hello World! -")));
        btn.setOnAction(event -> {
            pane.getChildren().add(new Label("Some text"));
            System.out.println("Some console output.");
        });
        */

        return pane;
    }

    public static void main(String[] args) {
        launch(args);
    }

}

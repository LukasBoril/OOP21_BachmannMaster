package ch.zhaw.exercises.le01.task4;

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

public class LayoutExample extends Application {
   /* public void start(Stage primaryStage) {
        Label l1 = new Label("Hallo");
        Label l2 = new Label("Welt");
        VBox root = new VBox();
       // root.getChildren().add(l1);
       // root.getChildren().add(l2);
       // root.getChildren().add(createButton());
        root.getChildren().add(createInputPane());
        root.getChildren().add(createToolbarPane());
        Scene scene = new Scene(root, 240, 40);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World");
        primaryStage.show();

    }*/

    public void start(final Stage primaryStage) {
        final BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(7, 7, 7, 7));
        borderPane.setTop(createToolbarPane());
        borderPane.setCenter(createInputPane());
        borderPane.setLeft(createNavigationPane());
        primaryStage.setTitle(LayoutExample.class.getSimpleName());
        primaryStage.setScene(new Scene(borderPane, 350, 250));
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

    private Pane createInputPane() {
        final GridPane gridPane = new GridPane();
        gridPane.setBorder(
                new Border(
                        new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, null,
                                new BorderWidths(5)))
        );
        gridPane.setPadding(new Insets(7, 7, 7, 7));
        gridPane.setGridLinesVisible(true);
        gridPane.setHgap(5);
        gridPane.setVgap(10);
        final Label label1 = new Label("Label1");
        final TextField textfield1 = new TextField();
        final Label label2 = new Label("Label2");
        final TextField textfield2 = new TextField();
        final Button button = new Button("Button");
        gridPane.add(label1, 0, 0);
        gridPane.add(textfield1, 1, 0);
        gridPane.add(label2, 0, 1);
        gridPane.add(textfield2, 1, 1);
        gridPane.add(button, 1, 2);
        return gridPane;
    }

    private Pane createToolbarPane() {
        final HBox hbox = new HBox(5);
        hbox.setStyle("-fx-border-width: 2;-fx-border-color: red;");
        hbox.getChildren().addAll(
                new Text("TOP"), new Button("HBox1"), new Button("HBox2"));
        return hbox;
    }

    private Pane createNavigationPane() {
        final VBox vbox = new VBox(5);
        vbox.setStyle("-fx-border-width: 2;-fx-border-color: red;");
        vbox.getChildren().addAll(new Text("LEFT"),
                new Button("VBox1"),
                new Button("VBox2"));
        return vbox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
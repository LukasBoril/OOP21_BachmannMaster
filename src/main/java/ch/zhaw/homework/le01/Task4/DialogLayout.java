package ch.zhaw.homework.le01.Task4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DialogLayout extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(final Stage primaryStage) {
        //create new BoarderPane
        final BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(7));
        borderPane.setTop(createToolbarPane());
        borderPane.setCenter(createInputPane());
        borderPane.setLeft(createNaviagationPane());

        //primaryStage.setTitle(LayoutExample.class.getSimpleName());
        primaryStage.setScene(new Scene(borderPane,320,250));
        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }


    public Pane createToolbarPane() {
        final HBox hBox = new HBox(5);
        hBox.setStyle("-fx-border-with: 2; -fx-border-color: red;");
        hBox.getChildren().addAll(new Label("TOP"), new Button("HBox1"), new Button("HBox2"));
        return hBox;
    }

    public Pane createNaviagationPane() {
        final VBox vBox = new VBox(10);
        vBox.setStyle("-fx-border-with: 2; -fx-border-color: red;");
        vBox.getChildren().addAll(new Label("LEFT"), new Button("VBox1"), new Button("VBox2"));
        return vBox;
    }

    public Pane createInputPane() {
        final GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-border-with: 5; -fx-border-color: green;");
        gridPane.setPadding(new Insets(7));
        gridPane.setHgap(5);
        gridPane.setVgap(10);
        gridPane.setGridLinesVisible(true);



        TextField textfield1 = new TextField();
        TextField textfield2 = new TextField();
        gridPane.add(new Label("Label1"),0,0);
        gridPane.add(textfield1,1,0);
        gridPane.add(new Label("Label2"),0,1);
        gridPane.add(textfield2,1,1);
        gridPane.add(new Button("Button"),1,2);

        return gridPane;
    }
}

package ch.zhaw.homework.le01.Wissenssicherung;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DecidingButton extends Application {



    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();
        root.getChildren().add(createButton());

        Scene scene = new Scene(root, 240, 240);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Deciding Button");
        primaryStage.show();

    }

    Pane createButton() {
        final Button btn = new Button();
        btn.setText("Klick Mich");// den Button ein Namen geben
        btn.setMinSize(200,100);
        final FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(7, 7, 7, 7));// Abstand Pane zum Scene Rand
        pane.getChildren().add(btn);

        // ActionHandler registrieren
        Answer answer = new Answer();
        btn.setOnAction(event -> btn.setText(answer.getAnswer())); // Lammda Ausdruck

        return pane;
    }


    public static void main(String[] args) {

        launch(args);
    }
}

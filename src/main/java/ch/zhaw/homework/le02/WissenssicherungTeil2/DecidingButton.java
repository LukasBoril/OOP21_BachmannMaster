package ch.zhaw.homework.le02.WissenssicherungTeil2;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DecidingButton extends Application {

    Answer answer = new Answer();

    @Override
    public void start(Stage primaryStage) {

        Label label = new Label("Antwort einfügen: ");
        TextField textField =new TextField();
        Button saveButton = new Button("save");

        //Oberste Zeile erstellen
        HBox hbox = new HBox(label, textField, saveButton);

        // Antwort befüllen
        saveButton.setOnAction(evt -> answer.setAnswer(textField.getText()));

        VBox root = new VBox(hbox);
        root.getChildren().add(createButton());

        Scene scene = new Scene(root, 540, 200);
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

        btn.setOnAction(event -> btn.setText(answer.getAnswer())); // Lammda Ausdruck

        return pane;
    }


    public static void main(String[] args) {

        launch(args);
    }
}

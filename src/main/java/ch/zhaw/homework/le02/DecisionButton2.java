package ch.zhaw.homework.le02;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class DecisionButton2 extends Application {

    private Random random = new Random();
    private ArrayList<String> t;

    @Override
    public void start(Stage stage) throws Exception {

        this.t = initValues();

        BorderPane root = new BorderPane();

        root.setTop(createTopPane());
        root.setCenter(createCenterPane());

        Scene scene = new Scene(root, 240, 100);

        stage.setScene(scene);
        stage.setTitle("Entscheidungsknopf");
        stage.show();
    }

    Pane createCenterPane(){
        Button button = new Button("Klick mich");
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setOnAction(event -> button.setText(this.getRandomText()));

        Rectangle rectLeft = new Rectangle(30, 20);
        rectLeft.setFill(Color.TRANSPARENT);
        Rectangle rectRight = new Rectangle(30, 20);
        rectRight.setFill(Color.TRANSPARENT);

        HBox boxCenter = new HBox(10, rectLeft, button, rectRight);
        boxCenter.setAlignment(Pos.CENTER);
        HBox.setHgrow(button, Priority.ALWAYS);

        return boxCenter;
    }

    Pane createTopPane(){
        VBox boxTop = new VBox();
        Label label = new Label("Tat:");
        TextField textField = new TextField();
        Button buttonSave = new Button("Save");
        boxTop.getChildren().add(label);
        boxTop.getChildren().add(textField);
        boxTop.getChildren().add(buttonSave);

        EventHandler<ActionEvent> onTextEnter = actionEvent -> {
            if(textField.getText().isEmpty()){
                displayAlert("Bitte text eingeben!");
            } else if (t.contains(textField.getText())){
                displayAlert("Tat " + textField.getText() +
                        " ist bereits in Liste enthalten");
            } else {
                t.add(textField.getText());
                textField.clear();
            }
        };

        buttonSave.setOnAction(onTextEnter);
        textField.setOnAction(onTextEnter);

        return boxTop;
    }

    private void displayAlert(String alertText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Entscheidungsknopf");
        alert.setHeaderText(alertText);
        alert.showAndWait();
    }

    private String getRandomText(){
        return t.get(random.nextInt(t.size()));
    }

    private ArrayList<String> initValues(){
        ArrayList<String> t = new ArrayList<>();

        t.add("Kino");
        t.add("Essen gehen");
        t.add("Konzert");

        return t;
    }

}

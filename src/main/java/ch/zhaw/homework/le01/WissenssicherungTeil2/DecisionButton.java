package ch.zhaw.homework.le01.WissenssicherungTeil2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DecisionButton extends Application {

    private List<String> possibleActivities;
    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.possibleActivities = new ArrayList<>();

        BorderPane rootBorderPane = new BorderPane();
        rootBorderPane.setTop(createTop());
        rootBorderPane.setCenter(createCenterPane());
        rootBorderPane.setBottom(createBottonPane());

        Scene scene = new Scene(rootBorderPane, 300, 250);
        primaryStage.setTitle("DecisionButton");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node createTop() {
        final Label label = new Label("Enter Activity:");
        final TextField textField = new TextField();
        final Button save = new Button("add");

        EventHandler<ActionEvent> onTextEnter = event -> {
            String s = textField.getText();

            if (s.isEmpty()) {
                displayAlert("Please Enter an Activity");
                return;
            }

            if (possibleActivities.contains(s)) {
                displayAlert("No duplicates allowed. " + s + " already exists.");
                textField.clear();
                return;
            }

            addActivity(s);
            textField.clear();
        };

        textField.setOnAction(onTextEnter);
        save.setOnAction(onTextEnter);

        HBox top = new HBox(10, label, textField, save);
        top.setPadding(new Insets(5, 5, 5, 5));

        return top;
    }

    private Node createCenterPane() {
        Button decisionButton = new Button("click me");
        decisionButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        decisionButton.setOnAction(event -> {
            if (possibleActivities.isEmpty()) {
                displayAlert("No activities!");
            } else {
                decisionButton.setText(getRandomActivity());
            }
        });

        Rectangle left = new Rectangle(30, 20);
        left.setFill(Color.TRANSPARENT);
        Rectangle right = new Rectangle(30, 20);
        right.setFill(Color.TRANSPARENT);

        HBox boxCenter = new HBox(10, left, decisionButton, right);
        boxCenter.setAlignment(Pos.CENTER);
        HBox.setHgrow(decisionButton, Priority.ALWAYS);

        return boxCenter;
    }

    private Node createBottonPane() {
        return new HBox(new Label());
    }

    private String getRandomActivity() {
        return possibleActivities.isEmpty() ? "click me" : possibleActivities.get(random.nextInt(possibleActivities.size()));
    }

    private void addActivity(String activity) {
        possibleActivities.add(activity);
    }

    private void displayAlert(String alertText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Decision Button");
        alert.setHeaderText(alertText);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

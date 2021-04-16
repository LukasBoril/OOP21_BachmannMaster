package ch.zhaw.homework.le01.WissenssicherungTeil1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

        this.possibleActivities = initActivities();

        BorderPane rootBorderPane = new BorderPane();
        rootBorderPane.setTop(createTopLabel());
        rootBorderPane.setCenter(createCenterPane());
        rootBorderPane.setBottom(createBottonPane());

        Scene scene = new Scene(rootBorderPane, 300, 250);
        primaryStage.setTitle("DecisionButton");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node createTopLabel() {
        Label label = new Label("Was machen wir heute Abend?");
        label.setPadding(new Insets(20, 10, 20, 0));

        HBox top = new HBox(label);
        top.setAlignment(Pos.CENTER);

        return top;
    }

    private Node createCenterPane() {
        Button decisionButton = new Button("click me");
        decisionButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        decisionButton.setOnAction(event -> decisionButton.setText(getRandomActivity()));

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
        return possibleActivities.get(random.nextInt(possibleActivities.size()));
    }

    private List<String> initActivities() {
        List<String> activities = new ArrayList();

        activities.add("Watch magnum pi");
        activities.add("Play Pokemon on gameboy color");
        activities.add("Drink a beer with friends");
        activities.add("Go for a walk");
        activities.add("Eat a Pizza");
        activities.add("Visit parents");

        return activities;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

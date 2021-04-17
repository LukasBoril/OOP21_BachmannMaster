package ch.zhaw.homework.le01;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class DecisionButton1 extends Application {

    private Random random = new Random();
    private ArrayList<String> t;

    @Override
    public void start(Stage stage) throws Exception {

        this.t = initValues();

        BorderPane root = new BorderPane();

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

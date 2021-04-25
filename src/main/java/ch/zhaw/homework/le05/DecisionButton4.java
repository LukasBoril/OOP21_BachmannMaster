package ch.zhaw.homework.le05;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class DecisionButton4 extends Application{

    private DecisionData decisionData;

    @Override
    public void start(Stage stage) throws Exception {

        decisionData = new DecisionData();

        BorderPane root = new BorderPane();

        root.setTop(createMenuBar());
        root.setCenter(createCenterPane());
        root.setBottom(createBottomPane());

        Scene scene = new Scene(root, 240, 100);

        stage.setScene(scene);
        stage.setTitle("Entscheidungsknopf");
        stage.show();
    }

    private Node createMenuBar(){

        Menu files = new Menu("Datei");
        Menu strategy = new Menu("Strategy");

        MenuItem saveDecision = new MenuItem("Speichere Entscheidungen");
        MenuItem loadDecision = new MenuItem("Lade Entscheidungen");
        MenuItem objectStategy = new MenuItem("Object Stream IO");
        MenuItem fileStrategy = new MenuItem("File Stream IO");

        saveDecision.setOnAction(actionEvent -> decisionData.saveDecision());
        loadDecision.setOnAction(actionEvent -> decisionData.loadDecision());
        objectStategy.setOnAction(actionEvent -> decisionData.setIOStategy(new ObjectIOStrategy()));
        fileStrategy.setOnAction(actionEvent -> decisionData.setFileStrategy(new FileIOStrategy()));

        files.getItems().addAll(saveDecision, loadDecision);
        strategy.getItems().addAll(objectStategy, fileStrategy);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(files, strategy);

        return menuBar;
    }

    Pane createCenterPane(){
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
            } else if (decisionData.isInList(textField.getText())){
                displayAlert("Tat " + textField.getText() +
                        " ist bereits in Liste enthalten");
            } else {
                decisionData.addText(textField.getText());
                textField.clear();
            }
        };

        buttonSave.setOnAction(onTextEnter);
        textField.setOnAction(onTextEnter);

        return boxTop;
    }


    Pane createBottomPane(){
        Button button = new Button("Klick mich");
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setOnAction(event -> button.setText(decisionData.getRandomText()));

        HBox boxCenter = new HBox(button);
        boxCenter.setAlignment(Pos.CENTER);
        HBox.setHgrow(button, Priority.ALWAYS);

        return boxCenter;
    }


    private void displayAlert(String alertText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Entscheidungsknopf");
        alert.setHeaderText(alertText);
        alert.showAndWait();
    }
}

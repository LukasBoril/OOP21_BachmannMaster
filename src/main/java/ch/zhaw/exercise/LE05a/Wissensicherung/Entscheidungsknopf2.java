package ch.zhaw.exercise.LE05a.Wissensicherung;

import ch.zhaw.exercise.LE04.Wissensicherung.FileSelector;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Entscheidungsknopf2 extends Application {
    ArrayList<String> answers;
    Stage fenster;
    Scene szene1;
    Button button1, button2;
    TextField textField;
    private Random r = new Random();
    private FileSelector fileSelector = new FileSelector();


    @Override
    public void start(Stage primaryStage) {

        initArrayList();

        fenster = primaryStage;

        BorderPane layout1 = new BorderPane();

        szene1 = new Scene(layout1, 500, 500);

        layout1.setTop(setMenuBar());

        //layout1.setTop(setTopBox());
        layout1.setLeft(setTopBox());




        //layout1.getChildren().add(button1);
        layout1.setCenter(setButton1());




        fenster.show();
        fenster.setScene(szene1);



    }

    public MenuBar setMenuBar(){
// Create MenuBar
        MenuBar menuBar = new MenuBar();
// Create menus
        Menu fileMenu = new Menu("File");
        Menu strategyMenu = new Menu("Strategy");

        MenuItem saveItem = new MenuItem("Save");
        //newItem.setOnAction(this);
        MenuItem openFileItem = new MenuItem("Open File");

        MenuItem objectStreamItem = new MenuItem("Object Stream IO");
        MenuItem fileStreamItem = new MenuItem("File Stream IO");

        fileMenu.getItems().addAll(saveItem, openFileItem);
        strategyMenu.getItems().addAll(objectStreamItem, fileStreamItem);

        menuBar.getMenus().addAll(fileMenu, strategyMenu);

        saveItem.setOnAction(event -> fileSelector.saveFile(fenster));

        openFileItem.setOnAction(event -> fileSelector.loadFile(fenster));

        objectStreamItem.setOnAction(event -> new ObjectStreamStrategy(answers));


        return menuBar;
    }

    public HBox setTopBox(){
        HBox box = new HBox(10);
        textField = new TextField();
        button2 = new Button("add");
        final Label labelAmount = new Label("[0]");
        box.getChildren().addAll(textField, button2, labelAmount);


        EventHandler<ActionEvent> onTextEnter = event -> {

            if (textField.getText().isEmpty()) {
                System.out.println("Bitte Text eingeben!");
            } else {
                if (answers.contains(textField.getText())) {
                    System.out.println("Der Eintrag '" + textField.getText() + "' existiert bereits");
                } else {
                    answers.add(textField.getText());
                    textField.clear();
                }
            }
            labelAmount.setText("[" + answers.size() + "]");
        };

        button2.setOnAction(onTextEnter);
        textField.setOnAction(onTextEnter);

        return box;
    }

    public Button setButton1() {
        button1 = new Button("Klick mich!");
        button1.setOnAction(event -> button1.setText(generateRandomAnswer()));

        return button1;
    }

    public String generateRandomAnswer(){
        return answers.get(r.nextInt(answers.size()));
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void initArrayList(){
        answers = new ArrayList<>();
        answers.add("first");
        answers.add("second");
    }

}

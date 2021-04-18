package ch.zhaw.exercise.LE04.Wissensicherung;

import ch.zhaw.exercise.LE04.Task4.Auto;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Entscheidungsknopf2 extends Application {
    ArrayList<String> answers;
    Stage fenster;
    Scene szene1;
    Button button1, button2, button3, button4;
    TextField textField;
    private Random r = new Random();
    private FileSelector fileSelector = new FileSelector();
    //Label label1, label2;

    @Override
    public void start(Stage primaryStage) {

        initArrayList();

        fenster = primaryStage;

        BorderPane layout1 = new BorderPane();

        szene1 = new Scene(layout1, 500, 500);

        layout1.setTop(setMenuBar());

        //layout1.setTop(setTopBox());
        layout1.setLeft(setTopBox());



        button1 = setButton1();
        //layout1.getChildren().add(button1);
        layout1.setCenter(button1);




        fenster.show();
        fenster.setScene(szene1);



    }

    public MenuBar setMenuBar(){
// Create MenuBar
        MenuBar menuBar = new MenuBar();
// Create menus
        Menu fileMenu = new Menu("File");
        MenuItem saveItem = new MenuItem("Save");
        //newItem.setOnAction(this);
        MenuItem openFileItem = new MenuItem("Open File");

        fileMenu.getItems().addAll(saveItem, openFileItem);
        menuBar.getMenus().addAll(fileMenu);

        saveItem.setOnAction(event -> fileSelector.saveFile(fenster));
                /*{
            try {
                OutputStream fos = new FileOutputStream("src/main/java/ch/zhaw/exercise/LE04/Wissensicherung/answers.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(answers);

            } catch (IOException e){
                e.printStackTrace();
            }
        });*/

        openFileItem.setOnAction(event -> fileSelector.loadFile(fenster));

                /*{
            try {
                InputStream fis = new FileInputStream("src/main/java/ch/zhaw/exercise/LE04/Wissensicherung/answers.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);

                answers = (ArrayList<String>) ois.readObject();

            } catch (Exception e) { //konkrete Exceptions catchen besser, wenn Fehlertext an Anwender ausgeben werden soll
                // in diesem Fall "Class not Found..." und IOException mit || catchen.
                e.printStackTrace();
            }

        });*/

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
        Button button = new Button("Klick mich!");
        button.setOnAction(event -> button.setText(generateRandomAnswer()));
        return button;
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

    public void addToAnswers(String entry){
        answers.add(entry);
    }

}

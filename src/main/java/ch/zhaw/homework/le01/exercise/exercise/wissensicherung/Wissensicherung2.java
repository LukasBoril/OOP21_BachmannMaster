package ch.zhaw.homework.le01.exercise.exercise.wissensicherung;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import java.util.ArrayList;


public class Wissensicherung2 extends Application {

        //private ArrayList<Label> labels = new ArrayList<>();
        private ArrayList<String> labels = new ArrayList<>();
        randomGenerator random = new randomGenerator();

        @Override
        public void start(Stage primaryStage) {

            VBox root = new VBox();
            Scene scene = new Scene(root, 240, 40);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Entscheidungsknopf");
            primaryStage.show();
            //fillLabels();

            //root.getChildren().add(createButton()); // um methode von pane createButton aufzurufen

            //root.getChildren().add(createTextInput());
            Pane button = createButton();
            root.getChildren().add(button);
            Pane texinput = createTextInput();
            root.getChildren().add(texinput);



        }
    Pane createTextInput() {
        Label label1 = new Label("mögliche Option:");
        TextField textField = new TextField();
        final FlowPane pane = new FlowPane();
        //HBox hb = new HBox();
        //hb.getChildren().addAll(label1, textField);
        //hb.setSpacing(10);
        pane.getChildren().addAll(label1, textField);
        return pane;

    }

        Pane createButton () {
            final Button btn = new Button();
            btn.setText("Klick me");
            final FlowPane pane = new FlowPane();   //ein pane der dann das zuegs unten immer wiede rhinzufügt..
            pane.setPadding(new Insets(70, 7, 7, 30));
            pane.getChildren().add(btn);
            // ActionHandler registrieren
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //pane.getChildren().add(labels.get(random.getNextInt(labels.size()-1)));
                    String newText = labels.get(random.getNextInt(labels.size()));
                    btn.setText(newText);
                }
            });
            return pane;
        }

    Pane createSaveButton () {
        final Button btn = new Button();
        btn.setText("save");
        final FlowPane pane = new FlowPane();   //ein pane der dann das zuegs unten immer wiede rhinzufügt..
        pane.setPadding(new Insets(70, 7, 7, 30));
        pane.getChildren().add(btn);
        // ActionHandler registrieren
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //pane.getChildren().add(labels.get(random.getNextInt(labels.size()-1)));
                //String newText = labels.get(random.getNextInt(labels.size()));
                //btn.setText(newText);
            }
        });
        return pane;
    }

        void fillLabels()
        {
            //labels.add(new Label("Essen gehen"));
            // labels.add(new Label("Kino"));
            //labels.add(new Label("Couchpotating"));
            //labels.add(new Label("Konzert"));
            labels.add("Essen gehen");
            labels.add("Kino");
            labels.add("Couchpotating");
            labels.add("Konzert");

        }

        public static void main(String[] args) {
            launch(args);


        }
    }



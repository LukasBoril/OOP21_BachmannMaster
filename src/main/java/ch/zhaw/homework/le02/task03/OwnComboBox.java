package ch.zhaw.homework.le02.task03;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OwnComboBox extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        final String[] names = {"Julia", "Fabio", "Fabian", "Nadin"};
        final ObservableList<String> entries = FXCollections.observableArrayList(names);

        ComboBox<String> combobox = new ComboBox<>(entries);

        Button button = new Button("Add Names");
        //Button ohne Lambda
        /*button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int index = 0; index < names.length; index++) {
                    entries.addAll("Tim", "Tom");
                    combobox.show();
                }
            }
        });*/
        //Button mit Labda
        button.setOnAction(event -> {
            entries.addAll("Hans", "Ueli");
            combobox.show();
        });

        HBox layout = new HBox(20, combobox, button);


        primaryStage.setScene(new Scene(layout, 300,200));

        primaryStage.setTitle("Combobox Experiment1");
        primaryStage.show();
    }

    //Mainroutine
    public static void main(String[] args) {
        launch(args);
    }
}

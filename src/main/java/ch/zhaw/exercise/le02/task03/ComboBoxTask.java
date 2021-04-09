package ch.zhaw.exercise.le02.task03;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ComboBoxTask extends Application {

    @Override
    public void start(Stage stage){
        stage.setTitle("Combobox Experiment");

        final String[] names = {"Micha", "Andi", "Andy", "Tom", "Mischa"};
        final ObservableList<String> entries = FXCollections.observableArrayList(names);

        final ComboBox<String> comboNames = new ComboBox<>(entries);
        final Button addNamesButton = new Button("Add Names");
        addNamesButton.setOnAction(evt -> {
                    entries.addAll("Tim", "Mike");
                    comboNames.show();
        });

        HBox hBox = new HBox(comboNames, addNamesButton);

        Scene scene = new Scene(hBox, 200, 120);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}


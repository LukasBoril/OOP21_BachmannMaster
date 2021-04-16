package ch.zhaw.exercises.le02;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class ComboBoxExample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ComboBox Experiment 1");
        final String[] names = { "Micha", "Andi", "Andy", "Tom", "Matze" };
        final ObservableList<String> entries =
                FXCollections.observableArrayList(names);
        final ComboBox<String> comboNames = new ComboBox<>(entries);
        final Button addNamesBtn = new Button("Add Names");
        addNamesBtn.setOnAction(evt -> {
            entries.addAll("Tim", "Mike");
            comboNames.show();
        });
        HBox hbox = new HBox(comboNames, addNamesBtn);
        Scene scene = new Scene(hbox, 200, 120);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
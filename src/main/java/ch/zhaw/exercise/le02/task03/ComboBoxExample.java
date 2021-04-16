package ch.zhaw.exercise.le02.task03;

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
        primaryStage.setTitle("ComboBox Example");

        String[] names = {"Hans", "Anna", "Jules", "Antony" };
        ObservableList<String> dropDownEntries = FXCollections.observableArrayList(names);
        ComboBox<String> comboBox = new ComboBox<>(dropDownEntries);
        Button addNamesBtn = new Button("Add Names");
        addNamesBtn.setOnAction(event -> {
            dropDownEntries.addAll("Timmy", "Thommy");
            comboBox.show();
        });

        HBox hbox= new HBox(comboBox, addNamesBtn);
        Scene scene= new Scene(hbox, 200, 120);
        primaryStage.setScene(scene);primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

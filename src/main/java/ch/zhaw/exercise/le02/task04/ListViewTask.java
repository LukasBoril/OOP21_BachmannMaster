package ch.zhaw.exercise.le02.task04;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewTask extends Application {

    @Override
    public void start(Stage stage){

        stage.setTitle("ListView Example");

        final String[] names = {"Micha", "Andi", "Andy", "Tom", "Matze"};
        final ObservableList<String> entries = FXCollections.observableArrayList(names);
        final ListView<String> listView = new ListView<>(entries);
        final SelectionModel<String> selectionModel = listView.getSelectionModel();

        Button readButton = new Button("Read Selected Value");
        Button addButton = new Button("Add");
        TextField textField = new TextField();
        Button removeButton = new Button("Remove");
        HBox hbox = new HBox(addButton, textField, removeButton);

        removeButton.disableProperty().bind(Bindings.isNull(selectionModel.selectedItemProperty()));

        addButton.setOnAction(event -> {
            entries.add(textField.getText());
        });

        readButton.setOnAction(event -> {
            System.out.println("o = " + selectionModel.selectedItemProperty().getValue());
        });

        removeButton.setOnAction(event -> {
            String selectedValue = selectionModel.selectedItemProperty().getValue();
            entries.remove(selectedValue);
        });

        VBox vBox = new VBox(hbox, listView, readButton);

        Scene scene = new Scene(vBox, 300, 280);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

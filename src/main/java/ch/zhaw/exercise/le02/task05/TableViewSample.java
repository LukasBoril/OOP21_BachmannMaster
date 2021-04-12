package ch.zhaw.exercise.le02.task05;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewSample extends Application {
    @Override
    public void start(Stage primaryStage) {
        // data for the tableview. modifying this list automatically updates the tableview
        ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("John Doe", 1.75),
                new Person("Mary Miller", 1.70),
                new Person("Frank Smith", 1.80),
                new Person("Charlotte Hoffman", 1.80)
        );

        TableView<Person> tableView = new TableView<>(data);

        // table column for the name of the person
        TableColumn<Person, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(param -> param.getValue().nameProperty());

        // column for the size of the person
        TableColumn<Person, Number> sizeColumn = new TableColumn<>("Size");
        sizeColumn.setCellValueFactory(param -> param.getValue().sizeProperty());

        // add columns to tableview
        tableView.getColumns().add(nameColumn);
        tableView.getColumns().add(sizeColumn);

        // Edit Fields
        TextField name = new TextField();
        TextField size = new TextField();
        size.setPrefWidth(50);

        // convert input from textfield to double
        TextFormatter<Double> sizeFormatter = new TextFormatter<Double>(new DoubleStringConverter());
        size.setTextFormatter(sizeFormatter);

        // Commit the changes from the edit fields to the table
        Button commit = new Button("Change Item");
        commit.setOnAction(event -> {
            Person p = tableView.getSelectionModel().getSelectedItem();
            p.setName(name.getText());
            Double value = sizeFormatter.getValue();
            p.setSize(value == null ? -1d : value);
        });

        // listen for changes in the selection for updating the data in the text fields name and size
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            commit.setDisable(newValue == null);
            if (newValue != null) {
                sizeFormatter.setValue(newValue.getSize());
                name.setText(newValue.getName());
            }
        });

        HBox editors = new HBox(5, new Label("Name:"), name, new Label("Size: "), size, commit);
        editors.setPadding(new Insets(10,10,15,10));
        VBox root = new VBox(10, tableView, editors);
        VBox.setVgrow(tableView, Priority.ALWAYS);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        System.setProperty("prism.lcdtext", "false");
        launch(args);
    }

}

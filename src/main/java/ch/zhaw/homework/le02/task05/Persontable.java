package ch.zhaw.homework.le02.task05;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Persontable extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("Jakob", "Schmid", "js@andritz.com"),
                new Person("Hans", "Gasser", "gass@gmx.com"),
                new Person("Claudia", "Egli", "egli@andritz.com")
        );

        TableView<Person> table = new TableView<>(data);
        table.setEditable(true);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); //Damit werden nur 3 Spalten angezeigt

        Label titleLabel = new Label("AddressBook");
        titleLabel.setFont(new Font("Arial", 20));

        //First Column
        TableColumn<Person, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setMinWidth(100);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));

        //second Column
        TableColumn<Person, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setMinWidth(100);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));

        //third Column
        TableColumn<Person, String> eMailColumn = new TableColumn<>("Email adress");
        eMailColumn.setMinWidth(200);
        eMailColumn.setResizable(true);
        eMailColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("eMail"));

        table.setItems(data);
        table.getColumns().addAll(firstNameColumn, lastNameColumn, eMailColumn);

        VBox vBox = new VBox(titleLabel,table);
        vBox.setPadding(new Insets(10,10,10,10));


        Scene scene = new Scene(vBox, 500,300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Table View Sampla");
        primaryStage.show();
    }

    //Mainroutine
    public static void main(String[] args) {
        launch(args);
    }
}

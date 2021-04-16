package ch.zhaw.homework.le04;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


public class OvnListfield extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btnAdd = new Button("Add");
        Button btnRemove = new Button("Remove");
        TextField textfield = new TextField();
        textfield.setMinWidth(50);

        //set up comandLine on Top
        HBox comandLine = new HBox(5, btnAdd, textfield, btnRemove);

        //set up the VBox with the commandline and Textlist and bothom button
        final String[] names = {"Hans", "Julia","Fabio","Matthias"};
        final ObservableList<String> entries = FXCollections.observableArrayList(names);
        final ListView<String> listView = new ListView<>(entries);
        Button btnRead = new Button("Read Selected Value");
        final SelectionModel<String> selectedModul = listView.getSelectionModel();

        VBox vBox = new VBox(comandLine, listView, btnRead);


        //ButtonAction
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textfield.getCharacters().length()>0) {
                    entries.add(textfield.getText());
                }
            }
        });

        btnRemove.disableProperty().bind(
                Bindings.isNull(selectedModul.selectedItemProperty()));
        btnRemove.setOnAction(event -> {
            String selectedValue = selectedModul.selectedItemProperty().getValue();
            entries.remove(selectedValue);
        });

        btnRead.setOnAction(event -> {
            System.out.println(selectedModul.selectedItemProperty().getValue());
        });


        //set up the scene
        Scene scene = new Scene(vBox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("ListView Experiment1");
        primaryStage.show();
    }

    //Mainroutine
    public static void main(String[] args) {
        launch(args);
    }
}

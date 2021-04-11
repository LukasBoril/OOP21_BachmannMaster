package ch.zhaw.exercise.le02.task05x2;

import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MainView {

    PersonTableView personTableView;
    Stage primaryStage;
    String osName;

    public MainView(Stage primaryStage) {
        this.primaryStage = primaryStage;
        osName = System.getProperty("os.name").toLowerCase();
        buildUI(primaryStage);
    }

    private void buildUI(Stage primaryStage) {
        BorderPane root = new BorderPane();

        personTableView = initTableData();
        root.setTop(initMenu());
        VBox vBox = new VBox(initToolBar(), personTableView);
        root.setCenter(vBox);

        Scene scene = new Scene(root, 500, 300);
        scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
        primaryStage.setTitle("TableView Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MenuBar initMenu () {
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem( "E_xit" );
        if (osName.contains("mac")) {
            exitItem.setAccelerator( new KeyCodeCombination( KeyCode.Q, KeyCombination.SHORTCUT_DOWN ));
        } else if (osName.contains("win")){
            exitItem.setAccelerator( new KeyCodeCombination( KeyCode.F4, KeyCombination.ALT_DOWN ));
        } else {
            exitItem.setAccelerator( new KeyCodeCombination( KeyCode.X, KeyCombination.CONTROL_DOWN ));
        }
        exitItem.setMnemonicParsing( true );
        exitItem.setOnAction( ( event ) -> primaryStage.close() );
        fileMenu.getItems().add(exitItem);
        return new MenuBar(fileMenu);
    }

    private Pane initToolBar() {
        Button addButton = new Button("Add...");
        addButton.setOnAction(event -> addPerson());

        Button editButton = new Button("Edit...");
        editButton.setOnAction(event -> editPerson());

        Button removeButton = new Button("Remove");
        removeButton.setOnAction(event -> personTableView.removeSelectedRow());

        editButton.disableProperty().bind(Bindings.isNull(personTableView.getSelectedItemProperty()));
        removeButton.disableProperty().bind(Bindings.isNull(personTableView.getSelectedItemProperty()));

        return new HBox(addButton, editButton, removeButton);
    }

    private void addPerson() {
        PersonEditDialog dialog = new PersonEditDialog();
        Optional<Person> person = dialog.showAndWait();

        person.ifPresent(theEditedPerson -> {
            System.out.println("Last Name=" + theEditedPerson.getFirstName() +
                    ", FirstName=" + theEditedPerson.getLastName()  +
                    ", Age=" + theEditedPerson.getAge());
            personTableView.add(theEditedPerson);
            // personTableView.refresh();
        });
    }


    private void editPerson() {
        PersonEditDialog dialog = new PersonEditDialog(personTableView.getSelectedItemProperty().getValue());
        Optional<Person> person = dialog.showAndWait();

        person.ifPresent(theEditedPerson -> {
            System.out.println("Last Name=" + theEditedPerson.getFirstName() +
                    ", FirstName=" + theEditedPerson.getLastName()  +
                    ", Age=" + theEditedPerson.getAge());
            Person selectedPerson = personTableView.getSelectedItemProperty().getValue();
            selectedPerson.setFirstName(theEditedPerson.getFirstName());
            selectedPerson.setLastName(theEditedPerson.getLastName());
            selectedPerson.setAge(theEditedPerson.getAge());
            personTableView.refresh();
        });
    }

    private PersonTableView initTableData() {
        PersonTableView table = new PersonTableView();
        table.add(new Person("Buggs", "Bunny", 79));
        table.add(new Person("Daffy", "Duck", 83));
        table.add(new Person("Foghorn", "Leghorn", 74));
        table.add(new Person("Elmer", "Fudd", 83));
        table.add(new Person("Tweety", "Bird", 73));
        return table;
    }





}

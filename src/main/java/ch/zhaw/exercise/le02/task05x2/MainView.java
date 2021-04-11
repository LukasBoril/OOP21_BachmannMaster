package ch.zhaw.exercise.le02.task05x2;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Optional;

public class MainView {

    PersonTableView personTableView;
    Stage primaryStage;
    String osName;
    int javaFxVersion;

    public MainView(Stage primaryStage) {
        this.primaryStage = primaryStage;
        osName = System.getProperty("os.name").toLowerCase();
        javaFxVersion = getJavaFxVersionNumber();
        buildUI(primaryStage);
    }

    private void buildUI(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 600, 400);

        personTableView = initTableData();
        root.setTop(initMenu());
        VBox vBox = new VBox(initToolBar(), personTableView);
        VBox.setVgrow(personTableView, Priority.ALWAYS);
        root.setCenter(vBox);

        personTableView.addOnDeleteListener(e -> deletePerson());
        personTableView.addOnEditListener(e -> editPerson());

        // Accelerators are working on the whole the scene where ever the keyboard focus is
        // Alternative in tableView.setOnKeyPressed() ... works only if the focus is on the table
        scene.getAccelerators().put(KeyCombination.keyCombination(String.valueOf(KeyCode.DELETE)), this::deletePerson);
        scene.getAccelerators().put(KeyCombination.keyCombination(String.valueOf(KeyCode.BACK_SPACE)), this::deletePerson);

        scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
        primaryStage.setTitle("TableView Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MenuBar initMenu() {
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        if (osName != null && osName.contains("mac")) {
            if (javaFxVersion >= 16) {
                Platform.runLater(() -> menuBar.useSystemMenuBarProperty().set(true));
            }
            exitItem.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.SHORTCUT_DOWN));
        } else if (osName != null && osName.contains("win")) {
            exitItem.setAccelerator(new KeyCodeCombination(KeyCode.F4, KeyCombination.ALT_DOWN));
        } else {
            exitItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
        }
        exitItem.setOnAction((event) -> primaryStage.close());
        fileMenu.getItems().add(exitItem);
        menuBar.getMenus().add(fileMenu);
        return menuBar;
    }

    private Pane initToolBar() {
        ImageView addIcon = new ImageView(new Image(getClass().getResourceAsStream("add.png")));
        Button addButton = new Button("Add...");
        addButton.setOnAction(event -> addPerson());
        addButton.setGraphic(addIcon);

        ImageView editIcon = new ImageView(new Image(getClass().getResourceAsStream("edit.png")));
        editIcon.setFitHeight(16);
        editIcon.setFitWidth(16);
        Button editButton = new Button("Edit...");
        editButton.setOnAction(event -> editPerson());
        editButton.setGraphic(editIcon);

        ImageView deleteIcon = new ImageView(new Image(getClass().getResourceAsStream("delete.png")));
        Button removeButton = new Button("Remove");
        removeButton.setOnAction(event -> deletePerson());
        removeButton.setGraphic(deleteIcon);

        editButton.disableProperty().bind(Bindings.isNull(personTableView.getSelectedItemProperty()));
        removeButton.disableProperty().bind(Bindings.isNull(personTableView.getSelectedItemProperty()));
        HBox hBox = new HBox(addButton, editButton, removeButton);
        hBox.setPadding(new Insets(5,5,5,5));
        return hBox;
    }

    private void addPerson() {
        PersonEditDialog dialog = new PersonEditDialog();
        Optional<Person> person = dialog.showAndWait();

        person.ifPresent(theEditedPerson -> {
            System.out.println("Last Name=" + theEditedPerson.getFirstName() +
                    ", FirstName=" + theEditedPerson.getLastName() +
                    ", Age=" + theEditedPerson.getAge());
            personTableView.add(theEditedPerson);
        });
    }


    private void editPerson() {
        PersonEditDialog dialog = new PersonEditDialog(personTableView.getSelectedItemProperty().getValue());
        Optional<Person> person = dialog.showAndWait();

        person.ifPresent(theEditedPerson -> {
            System.out.println("Last Name=" + theEditedPerson.getFirstName() +
                    ", FirstName=" + theEditedPerson.getLastName() +
                    ", Age=" + theEditedPerson.getAge());
            Person selectedPerson = personTableView.getSelectedItemProperty().getValue();
            selectedPerson.setFirstName(theEditedPerson.getFirstName());
            selectedPerson.setLastName(theEditedPerson.getLastName());
            selectedPerson.setAge(theEditedPerson.getAge());
            personTableView.refresh();
        });
    }

    private void deletePerson() {
        if (personTableView.getSelectedItemProperty() != null && personTableView.getSelectedItemProperty().getValue() != null) {
            personTableView.removeSelectedRow();
        }

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

    private int getJavaFxVersionNumber() {
        String javafxVersion = System.getProperty("javafx.version");
        if (javafxVersion != null) {
            String[] javafxVersionParts = javafxVersion.split("\\."); //array of strings
            if (javafxVersionParts[0] != null) {
                return Integer.parseInt(javafxVersionParts[0]);
            }
        }
        return 0;
    }


}

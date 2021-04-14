package ch.zhaw.homework.le01.task06_JavaFXMenue;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JFXMenue extends Application implements EventHandler<ActionEvent> {

    public void start(Stage primaryStage) {
        try {
            // Create MenuBar
            MenuBar menuBar = new MenuBar();

            // Create menus
            Menu fileMenu = new Menu("File");
            Menu editMenu = new Menu("Edit");
            Menu helpMenu = new Menu("Help");

            // Create MenuItems
            MenuItem newItem = new MenuItem("New");
            newItem.setOnAction(this);
            MenuItem openFileItem = new MenuItem("Open File");
            MenuItem exitItem = new MenuItem("Exit");

            // Set Accelerator for Exit MenuItem.
            exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));

            // When user click on the Exit item, use anonymous inner class
            exitItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.exit(0);
                }
            });

            MenuItem copyItem = new MenuItem("Copy");
            MenuItem pasteItem = new MenuItem("Paste");

            // Add menuItems to the Menus
            fileMenu.getItems().addAll(newItem, openFileItem, exitItem);
            editMenu.getItems().addAll(copyItem, pasteItem);

            // RadioMenuItem
            RadioMenuItem updateItem1 = new RadioMenuItem("Auto Update");
            RadioMenuItem updateItem2 = new RadioMenuItem("Ask for Update");
            ToggleGroup group = new ToggleGroup();
            updateItem1.setToggleGroup(group);
            updateItem2.setToggleGroup(group);
            updateItem1.setSelected(true);
            helpMenu.getItems().addAll(updateItem1, updateItem2);

            // Add Menus to the MenuBar
            menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);
            BorderPane root = new BorderPane();
            root.setTop(menuBar);
            Scene scene = new Scene(root, 350, 200);
            primaryStage.setTitle("JavaFX Menu");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
    }
}

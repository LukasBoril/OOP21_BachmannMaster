package ch.zhaw.homework.le04bo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Menu extends Application  {

    public void start(Stage primaryStage) {
        try {
            // Create MenuBar
            MenuBar menuBar = new MenuBar();

            // Create menus
            javafx.scene.control.Menu fileMenu = new javafx.scene.control.Menu("File");

            // Create MenuItems
            MenuItem load = new MenuItem("load");
            MenuItem store = new MenuItem("store");
            MenuItem exitItem = new MenuItem("Exit");

            // Set Accelerator for Exit MenuItem.
            exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));

            // When user click on the Exit item, exit session
            exitItem.setOnAction(event -> System.exit(0));

            // Add menuItems to the Menus
            fileMenu.getItems().addAll(load, store, exitItem);

            // Add Menus to the MenuBar
            menuBar.getMenus().addAll(fileMenu);
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

}

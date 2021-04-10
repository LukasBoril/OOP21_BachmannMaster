package ch.zhaw.exercise.le01.task07;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        //create a root and load fxml code
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        final Parent root = loader.load();

        // get the LoginController
        LoginController loginController = (LoginController) loader.getController();

        Scene scene = new Scene(root, 460, 180);
        // Load CSS
        scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
        stage.setScene(scene);

        stage.setTitle("FXML Demo");
        stage.show();
    }

    public static void main(final String[] args) {
        System.setProperty("prism.lcdtext", "false");
        launch(args);
    }
}

package ch.zhaw.exercise.le01.task07;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        LoginController controller = (LoginController) loader.getController();

        Scene scene = new Scene(root, 460, 180);

        scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("FXML Demo");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

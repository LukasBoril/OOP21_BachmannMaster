package ch.zhaw.exercise.le01.task02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HelloWorld extends Application {


	public void start(Stage primaryStage) {
		Label l1 = new Label("Hallo");
		Label l2 = new Label("Welt");
		VBox root = new VBox();
		root.getChildren().add(l1);
		root.getChildren().add(l2);

		Scene scene = new Scene(root, 240, 40);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello World");
		primaryStage.show();

	}

	public static void main(String[] args) {
		System.setProperty("prism.lcdtext", "false");
		launch();
	}

}

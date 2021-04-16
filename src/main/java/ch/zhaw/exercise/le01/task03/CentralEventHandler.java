package ch.zhaw.exercise.le01.task03;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CentralEventHandler extends Application implements EventHandler<ActionEvent> {

	Pane pane;

	public void start(Stage primaryStage) {
		Label l1 = new Label("Hallo");
		Label l2 = new Label("Welt");
		VBox root = new VBox();
		root.getChildren().add(l1);
		root.getChildren().add(l2);
		root.getChildren().add(createButton());

		Scene scene = new Scene(root, 240, 140);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello World");
		primaryStage.show();
	}

	Pane createButton() {
		final Button btn = new Button();
		btn.setText("Add 'Hello World' Label");
		pane = new FlowPane();
		pane.setPadding(new Insets(7, 7, 7, 7));
		pane.getChildren().add(btn);
		// ActionHandler registrieren$
		btn.setOnAction(this);

		return pane;
	}



	public static void main(String[] args) {
		System.setProperty("prism.lcdtext", "false");
		launch();
	}


	@Override
	public void handle(ActionEvent event) {
		System.out.println("Action Handler");
		Label lAdd = new Label("- Hello World! -");
		pane.getChildren().add(lAdd);

	}
}
package ch.zhaw.exercise.le01.task05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LambdaEventHandler extends Application {

	Stage fenster;
	Scene szene1, szene2;
	Button button1, button2;
	Label label1, label2;


	@Override
	public void start(Stage primaryStage) {
		try {

			fenster = primaryStage;
			label1 = new Label("Das ist die erste Szene");
			button1 = new Button("Zur zweiten Szene wechslen");
			button1.setOnAction(e ->  {
				fenster.setScene(szene2);
				fenster.show();
			});

			VBox layout1 = new VBox(30);
			layout1.getChildren().addAll(label1, button1);
			szene1 = new Scene(layout1, 250, 250);

			label2 = new Label("Das ist die zweite Szene");
			button2 = new Button("Zur ersten Szene wechslen");
			button2.setOnAction(e ->  {
				fenster.setScene(szene1);
				fenster.show();
			});

			VBox layout2 = new VBox(30);
			layout2.getChildren().addAll(label2, button2);
			szene2 = new Scene(layout2, 250, 250);

			primaryStage.setScene(szene1);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}


}

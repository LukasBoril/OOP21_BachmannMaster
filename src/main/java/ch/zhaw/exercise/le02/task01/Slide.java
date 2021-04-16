package ch.zhaw.exercise.le02.task01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Slide extends Application {
	@Override
	public void start(Stage stage) {
		Label label = new Label();
		Slider slider = new Slider(10, 100, 42.195);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setMajorTickUnit(10);
		slider.setBlockIncrement(10);

		// label.textProperty().bind(Bindings.format("%.2f", slider.valueProperty()));
		slider.rotateProperty().bind(slider.valueProperty());

		VBox layout = new VBox(10, label, slider);
		layout.setStyle("-fx-padding: 10px; -fx-alignment: baseline-right");

		stage.setScene(new Scene(layout, 300, 100));
		stage.setTitle("Slider Example");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

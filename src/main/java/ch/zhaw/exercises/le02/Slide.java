package ch.zhaw.exercises.le02;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import javax.swing.*;

public class Slide extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label();
        TextField textField = new TextField();
        Slider slider = new Slider(1, 11, 5);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(1);
        slider.setBlockIncrement(1);
        textField.textProperty().bindBidirectional(slider.valueProperty(), new NumberStringConverter());
        VBox layout = new VBox(10, textField, slider);
        layout.setStyle("-fx-padding: 10px; -fx-alignment: baseline-right");
        stage.setScene(new Scene(layout, 300, 100));
        stage.setTitle("Goes to");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

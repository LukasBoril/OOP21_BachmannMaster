package ch.zhaw.exercise.le02.task01;

import javafx.application.Application;
import javafx.scene.control.Slider;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class SliderExample extends Application {
    @Override
    public void start(Stage stage) {
        //Label label_sliderValue = new Label();
        TextField textField_sliderValue = new TextField();
        Slider slider = new Slider(1, 10, 5);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setShowTickLabels(true);
        slider.setSnapToTicks(true);

        textField_sliderValue.textProperty().bindBidirectional(slider.valueProperty(), new NumberStringConverter());
        // label_sliderValue.textProperty().bind(Bindings.format("%i", slider.valueProperty()));

        VBox verticalBoxLayout = new VBox(10, textField_sliderValue, slider);
        verticalBoxLayout.setStyle("-fx-padding: 10px; -fx-alignment: baseline-right");
        stage.setScene(new Scene(verticalBoxLayout, 300, 100));
        stage.setTitle("Goes to");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

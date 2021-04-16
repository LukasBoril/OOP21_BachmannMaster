package ch.zhaw.homework.le02.task01;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UnidirectSlider extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label();
        Slider slider = new Slider(1,100,50);
        slider.setShowTickMarks(false);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(1);
        slider.setBlockIncrement(1);

        label.textProperty().bind(Bindings.format("%.2f",slider.valueProperty()));

        VBox layout = new VBox(10,label, slider);
        layout.setStyle("-fx-padding: 10px; -fx-alignment: baseline-right");

        stage.setScene(new Scene(layout,300,100));
        stage.setTitle("Goes to");
        stage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}

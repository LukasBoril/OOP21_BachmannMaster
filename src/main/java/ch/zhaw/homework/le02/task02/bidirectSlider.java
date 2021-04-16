package ch.zhaw.homework.le02.task02;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class bidirectSlider extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        TextField textfield = new TextField();
        Slider slider = new Slider(1,100,50);
        slider.setShowTickMarks(false);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(1);
        slider.setBlockIncrement(1);

        textfield.textProperty().bindBidirectional(slider.valueProperty(), new NumberStringConverter());
        //StringProperty myStringProp = textfield.textProperty();
        //myStringProp.bindBidirectional(slider.valueProperty(), new NumberStringConverter());

        VBox layout = new VBox(10,textfield, slider);
        layout.setStyle("-fx-padding: 10px; -fx-alignment: baseline-right");

        stage.setScene(new Scene(layout,300,100));
        stage.setTitle("Goes to");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

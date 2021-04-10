package ch.zhaw.eigeneProjekte;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;

/**
 * THis Game creats a a screen with one button that are to be pressed. If it gets pressed a new button gets randomly displayd
 */
public class ButtonGame extends Application {
    private static final int NUMBERBUTTONSLINE = 3;
    private static final int NUMBERBUTTONSCOLUMN = 3;

    public ButtonGame(){
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        HBox buttonPaneLine = new HBox();

        for (int line = 0; line< NUMBERBUTTONSLINE; line++) {
            buttonPaneLine.getChildren().add(createButton(line,1));
        }
    }

    public void createButton(int line, int column) {
        final Button btn = new Button();
        btn.setText((String) line);
    }
}

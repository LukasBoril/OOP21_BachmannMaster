package ch.zhaw.eigeneProjekte;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Random;

/**
 * THis Game creats a a screen with one button that are to be pressed. If it gets pressed a new button gets randomly displayd
 */
public class ButtonGame extends Application {
    private static final int NUMBERBUTTONSLINE = 3;
    private static final int NUMBERBUTTONSCOLUMN = 4;
    private static final int BUTTONSIZE = 80;
    private static final int BUTTONSPACE = 20;
    private static final boolean SHOWALLBUTTONS = false; //just for development
    private TilePane buttonPane;

    public ButtonGame(){
        buttonPane = new TilePane();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        //create the Pane
        //TilePane buttonPane = new TilePane();
        buttonPane.setTileAlignment(Pos.TOP_LEFT);
        buttonPane.setPrefColumns(NUMBERBUTTONSLINE);
        buttonPane.setPrefRows(NUMBERBUTTONSCOLUMN);
        buttonPane.setVgap(20);
        buttonPane.setHgap(20);
        buttonPane.setLayoutX(20);
        buttonPane.setLayoutY(20);

        //create the number of choosen Buttons and add it to the Pane
        int buttonNo = 1;
        for (int line = 0; line < NUMBERBUTTONSLINE; line++) {
            for (int column = 0; column < NUMBERBUTTONSCOLUMN; column++) {
                buttonPane.getChildren().add(createButton(line, column, buttonNo));
                buttonNo++;
            }
        }

        //create the Scene
        int sceneWidth = (NUMBERBUTTONSLINE * (BUTTONSIZE + BUTTONSPACE)) + BUTTONSPACE;
        int sceneHeight = (NUMBERBUTTONSCOLUMN * (BUTTONSIZE + BUTTONSPACE)) + BUTTONSPACE;
        Scene scene = new Scene(buttonPane, sceneWidth,sceneHeight);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Button Press Game");
        primaryStage.show();
    }

    /**
     * Methode creates a Button and names it with its number 1 to n
     * @return Button
     */
    public Button createButton(int line, int column, int buttonNo) {
        String stButtonNo = new Integer(buttonNo).toString();

        final Button btn = new Button();
        btn.setText(stButtonNo);
        btn.setPrefSize(BUTTONSIZE,BUTTONSIZE);

        //display first button or all Buttons
        btn.setVisible(SHOWALLBUTTONS || (line == 0 && column == 0));

        EventHandler<ActionEvent> btnEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showNextButton();
                //display first button or all Buttons
                btn.setVisible(false);
            }
        };
        btn.setOnAction(btnEvent);

        return btn;
    }

    public void showNextButton() {
        Random random = new Random();
        int nextRandomNo = -1;

        nextRandomNo = random.nextInt(NUMBERBUTTONSLINE * NUMBERBUTTONSCOLUMN);

        Button btn = (Button) buttonPane.getChildren().get(nextRandomNo);
        btn.setVisible(true);


    }
}

package ch.zhaw.homework.le01.WissenssicherungL01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class DecisionButton1 extends Application {

    private AntwortMap  answer;


    @Override
    public void start(Stage primaryStage) {

        answer= new AntwortMap();

        BorderPane root = new BorderPane();
        root.setTop(createTopPane());
        root.setCenter(createCenterPane());
        root.setBottom(createBottomPane());
        //root.setLeft(createLeftPane());

        Scene scene = new Scene(root,240, 140);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DecisionButton1");
        primaryStage.show();
    }


    /**
     * put the entry point somewhere in the top
     * of the source file. its easier for the moment
     * @param args parameter not needed
     */
    public static void main(String[] args) {
        launch(args);   //no high-res. screens checked here
    }

    /**
     * create the top pane
     * put in a HBox and in this a text
     *
     * @return the created box whit all its content to the top Pain
     */
    private Node createTopPane() {
        Label l1 = new Label("Was geht heute Abend?");
        l1.setPadding(new Insets(20, 0, 20, 0));

        HBox topBox = new HBox(l1);
        topBox.setAlignment(Pos.CENTER);

        return topBox;
    }

    /**
     * create the centre box as HBox and a button in it.
     * The button needs the answer to the text in the top box
     * this text will change randomly after clicking the answer
     * @return the the created box whit a button
     */
    private Node createCenterPane() {

        HBox centreBox = new HBox();
        Pane button = new Pane(createButton());
        //centreBox.setAlignment(Pos.CENTER);
        button.setPadding(new Insets(20, 0, 20, 0));
        centreBox.getChildren().add(button);

        return centreBox;
    }

    /*private Node createLeftPane() {

        Label emptyL = new Label();  //just an empty box

        HBox leftBox = new HBox(emptyL);
        leftBox.setAlignment(Pos.CENTER);

        return leftBox;
    }*/

    private Node createBottomPane() {

        Label empty = new Label();  //just an empty box

        HBox bottomBox = new HBox(empty);
        bottomBox.setAlignment(Pos.CENTER);

        return bottomBox;
    }

    /**
     * create the button used in the centreBox
     * @return button <btn>
     */
    private Pane createButton() {

        Button btn = new Button();
        btn.setText("klick me");
        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(7, 7, 7, 7));
        pane.getChildren().add(btn);

        // ActionHandler registrieren
        btn.setOnAction(event -> btn.setText(answer.standardantwortAuswählen()));

        return pane;
    }
}

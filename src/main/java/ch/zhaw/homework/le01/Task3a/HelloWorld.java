package ch.zhaw.homework.le01.Task3a;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        Label l1 = new Label("Hallo");
        Label l2 = new Label("Welt");
        Label l3 = new Label("1.Eintrag: was kann man damit machen beim zusammenschieben?");
        Label l4 = new Label("2.Eintrag");
        Label l5 = new Label("3.Eintrag");
        Label l6 = new Label("4.Eintrag");

        l6.setPrefSize(50,100);

        HBox root = new HBox();
        root.setSpacing(20);


        /*VBox root = new VBox();
        //VBox.setVgrow(l1, Priority.ALWAYS);
        //VBox.setVgrow(l2,Priority.SOMETIMES);
        //VBox.setVgrow(l3,Priority.NEVER);
        //VBox.setVgrow(l4,Priority.NEVER);
        //VBox.setVgrow(l5,Priority.NEVER);
        //VBox.setVgrow(l6,Priority.NEVER);*/

        /*AnchorPane root = new AnchorPane();

        AnchorPane.setBottomAnchor(l1,10.0);
        AnchorPane.setRightAnchor(l1,10.0);
        AnchorPane.setBottomAnchor(l1,10.0);
        AnchorPane.setTopAnchor(l2,30.0);*/

        root.getChildren().addAll(l1,l2,l3,l4,l5,l6);
        root.getChildren().add(createButton("HelloWorld"));
        root.getChildren().add(createButton("MyNewButton"));

        Scene scene = new Scene(root, 240,40);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World");
        primaryStage.setMaxHeight(300);
        primaryStage.setMaxWidth(1000);
        primaryStage.show();
    }

    public Pane createButton(String buttonText) {

        final Button btn = new Button();
        btn.setText("Add '"+ buttonText + "'");

        final FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(7));
        pane.getChildren().add(btn);


        btn.setOnAction(new EventHandler<ActionEvent>() {
            private int numberPress = 0;
            @Override
            public void handle(ActionEvent event) {
                if  (numberPress < 10) {
                    pane.getChildren().add(new Label(buttonText));
                    incrNumberPress();
                }
            }
            public void incrNumberPress() {
                numberPress ++;
            }
        });

        return pane;
    }


}

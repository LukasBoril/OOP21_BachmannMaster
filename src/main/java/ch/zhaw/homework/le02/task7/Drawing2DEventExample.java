package ch.zhaw.homework.le02.task7;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class Drawing2DEventExample extends Application {
    @Override
    public void start(Stage stage) {
        EventHandler<MouseEvent> eventHandler = getEventHandler();
// Drawing a Circle and registering the event handler
        Circle circle = new Circle(150, 135, 25, Color.BROWN);
        circle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

// Drawing a Circle2 and registering the event handler
        Circle circle2 = new Circle(300, 135, 25, Color.BROWN);
        circle2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
// Drawing a Circle3 and registering the event handler
        Circle circle3 = new Circle(450, 135, 25,Color.BROWN);
        circle3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
// Setting the text with coordinates
        Text text = new Text(150, 50, "Click on the circle to change its color");
// Setting the font of the text and setting the color of the text
        text.setFont(Font.font(null, FontWeight.BOLD, 15));
        text.setFill(Color.CRIMSON);
// Creating a Group object and a a scene object
        Group root = new Group(circle, circle2, circle3, text);
        Scene scene = new Scene(root, 600, 300);
// Setting the fill color to the scene and the title
        scene.setFill(Color.LAVENDER);
        stage.setTitle("Event Filters Example");
        stage.setScene(scene);
//Displaying the contents of the stage
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
    EventHandler<MouseEvent> getEventHandler () {
//Creating the mouse event handler
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Random rand = new Random();
                double r = rand.nextDouble();
                double g = rand.nextDouble();
                double b = rand.nextDouble();
                Color randomColor = new Color(r, g, b,1);
                System.out.println("The color is: " +
                        randomColor.toString());
                if (event.getSource() instanceof Circle) {
                    Circle c = (Circle) event.getSource();
                    c.setFill(randomColor);
                }
            }
        };
    } }

package ch.zhaw.homework.le04bo;

import ch.zhaw.homework.le04a.Auto;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;


public class DecisionButton3 extends Application {

    //private static final long serialVersionID = 123777L;
    //private ArrayList<String> randomText;
    //private final Random ran = new Random();
    private Randomizer randomText;
    private String fileName = "src/buttonText.ser";

    public DecisionButton3() {
        randomText = new Randomizer();
    }

    @Override
    public void start(Stage primaryStage) {


        BorderPane root = new BorderPane();
        root.setTop(createMenuPain());
        root.setCenter(createCenterPane());
        root.setBottom(createBottomPane());

        //create and show the scene
        Scene scene = new Scene(root,500, 200);
        primaryStage.setTitle("DecisionButton3");
        primaryStage.setScene(scene);
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
     * create the menu bar at the top of the Scene
     * contains a <load>, <save> and <exit> menu item
     * @return menuBar
     */
    private Node createMenuPain() {

        // Create MenuBar
        MenuBar menuBar = new MenuBar();

        // Create menus
        javafx.scene.control.Menu fileMenu = new javafx.scene.control.Menu("File");

        // Create MenuItems
        MenuItem load = new MenuItem("load");
        MenuItem store = new MenuItem("store");
        MenuItem exitItem = new MenuItem("Exit");

        // Set Accelerator for Exit MenuItem.
        exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));

        // When user click on the Exit item, exit session
        exitItem.setOnAction(event -> System.exit(0));

        // Add menuItems to the Menus
        fileMenu.getItems().addAll(load, store, exitItem);

        //if user clicks on store, run the serializable
        store.setOnAction(event -> serialize(randomText.getList()));

        //if user clicks on load, run the deSerializable
        load.setOnAction(event -> deSerialize(fileName));


        // Add Menus to the MenuBar
        menuBar.getMenus().addAll(fileMenu);

        return menuBar;
    }

    /**
     * create the centre box as HBox
     * It contains the input field for the data
     * @return centreBox
     */
    Pane createCenterPane() {
        final Label     whatsUp = new Label("whats up? Give your input -> ");
        final TextField inputField = new TextField();   //can read form keyboard
        final Label     inputAmount = new Label("[0]");
        final Button    saveButton = new Button("Save");

        EventHandler<ActionEvent> keyStroke = event -> {
            if(inputField.getText().isEmpty()) {
                displayAlert("Please put in your text");
            }
            else {
                if(randomText.getList().contains(inputField.getText())) {
                    displayAlert("this entry " + inputField.getText() + " already exists");
                } else {
                    randomText.addText(inputField.getText());
                    inputField.clear(); // clean up the input field for the next entry
                }
            }
            inputAmount.setText("[" + randomText.sizeOfList() + "]");
        };

        inputField.setOnAction(keyStroke);
        saveButton.setOnAction(keyStroke);

        HBox topBox = new HBox(10, whatsUp, inputField, inputAmount, saveButton);
        topBox.setPadding(new Insets(10, 0, 0, 0));
        topBox.setAlignment(Pos.TOP_CENTER);

        return topBox;
    }

    /**create the bottom box as HBox and a button in it.
     * The button shows some text out of the saved keystroke inputs
     * this text will change randomly after clicking the answer
     * @return boxCentre
     */

    private Node createBottomPane() {
        Button button = new Button("Klick me");
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        button.setOnAction(event -> {
            if (randomText.getRandomText().isEmpty()) {
                displayAlert("No entries in 'whats up?' ");
            }
            else {
                button.setText(this.randomText.getRandomText());
            }
        });

        Rectangle rectLeft = new Rectangle(30, 20);
        rectLeft.setFill(Color.TRANSPARENT);
        Rectangle rectRight = new Rectangle(30, 20);
        rectRight.setFill(Color.TRANSPARENT);

        HBox boxCenter = new HBox(10, rectLeft, button, rectRight);
        boxCenter.setPadding(new Insets(0, 0, 50, 0));
        boxCenter.setAlignment(Pos.CENTER);
        HBox.setHgrow(button, Priority.ALWAYS);

        return boxCenter;
    }

    /**
     * the Alert class is a separat class who creates an
     * action Pain showing the alert and contains all needed for
     * a simple alert info to the user. just try its "fully" automatic
     * @param alertString
     * @rturn a alert pain with info string <alertString>
     */
    private void displayAlert(String alertString) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert on\n<DecisionButton3>");
        alert.setHeaderText(alertString);
        alert.showAndWait();

    }

    /**
     * create a byte stream of the list received
     * and write it in a file to the given path
     * @param list
     */
    private void serialize(ArrayList<String> list) {

        if(list.isEmpty()) {
            System.out.println("the file is empty, so it will not be created/stored");
        }
        else {
            try (
                    OutputStream fos = new FileOutputStream("src/buttonText.ser");
                    ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(list);
                oos.close();
                fos.close();

                System.out.println("successfully wrote <text list> in to folder <ser>");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * deserialize form a file
     * and bring it back to the button
     * @return list
     */
    private ArrayList<String> deSerialize(String file) {

        ArrayList<String> list = new ArrayList<>();

        try (InputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            list = (ArrayList) ois.readObject();

            for(String content : list) {
               randomText.addText(content);
            }

            ois.close();
            fis.close();

            System.out.println("successfully read list file");
            System.out.println("----------------------------------");
            System.out.println(" ");
        }
        catch( ClassNotFoundException | IOException exception) {
            System.out.println("file not found");
            exception.printStackTrace();
        }
        return list;

    }
}


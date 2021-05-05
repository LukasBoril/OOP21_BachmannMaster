package ch.zhaw.eigeneProjekte.modularbeit.logSystem.maingui;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import ch.zhaw.eigeneProjekte.modularbeit.logSystem.logSystem.*;
import ch.zhaw.eigeneProjekte.modularbeit.logSystem.units.*;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainGui extends Application {
    LoggingUnit myChosenUnit;

    //Constructor
    public MainGui() {
        myChosenUnit = null;
    }

    //public static void main(String[] args) {
    //    launch(args);
    //}

    public void start(Stage primaryStage) {
        UnitHandler unitHandler = new UnitHandler();


        //ObservableList<LoggingUnit> obsUnits = FXCollections.observableList(unitHandler.getUnitSet());
        //ListView<LoggingUnit> listView = new ListView<>(obsUnits);

        ObservableList<String> obsUnits = FXCollections.observableArrayList();
        for (LoggingUnit oneUnit : unitHandler.getUnitSet()) {
            obsUnits.add(oneUnit.getUnitName());
        }
        ListView<String> unitlistView = new ListView<>(obsUnits);
        unitlistView.setPrefWidth(800);


        Button btnNewUnit = new Button("Add new Unit");
        btnNewUnit.setVisible(false);

        Button btnSaveUnits = new Button("Safe Units");
        Button btnRestorUnits = new Button("Restor Units");


        String[] units = { EnumUnits.ARDUINO.toString(), EnumUnits.RASPBERRY.toString()};
        ObservableList<String> diffUnits = FXCollections.observableArrayList(units);
        ComboBox<String> comboVendorUnits = new ComboBox<>(diffUnits);


        TextField unitName = new TextField("unit-name");
        unitName.setVisible(false);
        TextField ipAdress1 = new TextField("192");
        ipAdress1.setVisible(false);
        TextField ipAdress2 = new TextField("168");
        ipAdress2.setVisible(false);
        TextField ipAdress3 = new TextField("x");
        ipAdress3.setVisible(false);
        TextField ipAdress4 = new TextField("x");
        ipAdress4.setVisible(false);
        HBox ipAdrHBox = new HBox(5);
        ipAdrHBox.getChildren().addAll(ipAdress1, ipAdress2, ipAdress3, ipAdress4);

        TextField wifissid = new TextField("wifi-name");
        wifissid.setVisible(false);
        TextField wifipword = new TextField("wifi-password");
        wifipword.setVisible(false);

        Button btnConnect = new Button("Connect");
        btnConnect.setVisible(false);
        Circle connectionstate = new Circle(150, 135, 10, Color.GRAY);
        connectionstate.setVisible(false);

        Button btnSendComand1 = new Button("Comand1");
        btnSendComand1.setVisible(false);
        Button btnSendComand2 = new Button("Comand2");
        btnSendComand2.setVisible(false);
        Button btnSendComand3 = new Button("Comand3");
        btnSendComand3.setVisible(false);
        Label lblFeedback = new Label("---");
        lblFeedback.setVisible(false);

        //Action if the Button to "add new Unit" gets pressed (a new LoggingUnit gets created and displayed into the ListView)
        EventHandler newUnitEvent = event -> {
            String ipAdress = ipAdress1.getText() + "." + ipAdress2.getText() + "." +ipAdress3.getText() + "." +ipAdress4.getText();
            InetAddress inetadr;
            try {
                inetadr = Inet4Address.getByName(ipAdress);
                if (comboVendorUnits.getSelectionModel().getSelectedItem().equals(EnumUnits.ARDUINO.toString())) {
                    UnitArduino newUnit = new UnitArduino(unitName.getText(),inetadr, wifissid.getText(), wifipword.getText());
                    unitHandler.addUnit(newUnit);
                    obsUnits.add(newUnit.getUnitName());
                } else if(comboVendorUnits.getSelectionModel().getSelectedItem().equals(EnumUnits.RASPBERRY.toString()))  {
                    UnitRaspberry newUnit = new UnitRaspberry(unitName.getText(),inetadr, wifissid.getText(), wifipword.getText());
                    unitHandler.addUnit(newUnit);
                    obsUnits.add(newUnit.getUnitName());
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        };
        btnNewUnit.setOnAction(newUnitEvent);

        //Action if a Vendor gets selected (Display the "Add Unit-Button" and display all the Textfields for a new Unit)
        EventHandler<ActionEvent> unitVendorSelEvent = event -> {
            if (comboVendorUnits.getSelectionModel().getSelectedItem() != null) {
                unitName.setVisible(true);
                btnNewUnit.setVisible(true);
                ipAdress1.setVisible(true);
                ipAdress2.setVisible(true);
                ipAdress3.setVisible(true);
                ipAdress4.setVisible(true);
                wifissid.setVisible(true);
                wifipword.setVisible(true);
            } else {
                unitName.setVisible(false);
                btnNewUnit.setVisible(false);
                ipAdress1.setVisible(false);
                ipAdress2.setVisible(false);
                ipAdress3.setVisible(false);
                ipAdress4.setVisible(false);
                wifissid.setVisible(false);
                wifipword.setVisible(false);
            }
        };
        comboVendorUnits.addEventHandler(ActionEvent.ACTION, unitVendorSelEvent);

        //Action if the "Safe Units" button gets pressed (serialise all Units in the ListView)
        btnSaveUnits.setOnAction(event -> unitHandler.writeUnitsIntoFile());

        //Action if the "Restore Units" button gets pressed (deserialise all Units and display it on the ListView)
        btnRestorUnits.setOnAction(event -> {
            unitHandler.readUnitsOfFile();
            obsUnits.clear();
            for (LoggingUnit oneUnit : unitHandler.getUnitSet()) {
                obsUnits.add(oneUnit.getUnitName());
            }
        });

        //Action if an Unit gets selected in the ListView (Connectionstate and Button gets displayed)
        unitlistView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Selected item: " + newValue);
            if (newValue != null) {
                btnConnect.setVisible(true);
                connectionstate.setVisible(true);
                myChosenUnit = unitHandler.getCertainUnit(newValue);
                if (myChosenUnit.isConnected()) {
                    connectionstate.setFill(Color.GREEN);
                    btnConnect.setText("disconnect");
                } else {
                    connectionstate.setFill(Color.RED);
                    btnConnect.setText("connect");
                }
            } else {
                btnConnect.setVisible(false);
                connectionstate.setVisible(false);
                myChosenUnit = null;
            }
        });

        //Action if the "Connect-button" gets pressed (connect or disconnect will be performed)
        btnConnect.setOnAction(event -> {
            if (myChosenUnit != null) {
                if (!myChosenUnit.isConnected()) {
                    //connect
                    if (myChosenUnit.connect()) {
                        connectionstate.setFill(Color.GREEN);
                        btnConnect.setText("disconnect");
                        btnSendComand1.setVisible(true);
                        btnSendComand2.setVisible(true);
                        btnSendComand3.setVisible(true);
                        lblFeedback.setVisible(true);
                    } else {
                        connectionstate.setFill(Color.RED);
                    }
                } else {
                    //disconnect
                    if (myChosenUnit.disconnect()) {
                        connectionstate.setFill(Color.GREEN);
                    } else {
                        connectionstate.setFill(Color.RED);
                        btnConnect.setText("connect");
                        btnSendComand1.setVisible(false);
                        btnSendComand2.setVisible(false);
                        btnSendComand3.setVisible(false);
                        lblFeedback.setVisible(false);
                        lblFeedback.setText("---");
                    }
                }
            }
        });

        //Action of the "Comand-Buttons"
        btnSendComand1.setOnAction(event -> {
            if (myChosenUnit != null && myChosenUnit.isConnected()) {
                myChosenUnit.sendCommand(1);
                String str = Integer.toString(myChosenUnit.readCommandFeedback());
                lblFeedback.setText(str);
            }
        });
        btnSendComand2.setOnAction(event -> {
            if (myChosenUnit != null && myChosenUnit.isConnected()) {
                myChosenUnit.sendCommand(2);
                String str = Integer.toString(myChosenUnit.readCommandFeedback());
                lblFeedback.setText(str);
            }
        });
        btnSendComand3.setOnAction(event -> {
            if (myChosenUnit != null && myChosenUnit.isConnected()) {
                myChosenUnit.sendCommand(3);
                String str = Integer.toString(myChosenUnit.readCommandFeedback());
                lblFeedback.setText(str);
            }
        });

        HBox hBoxConnect = new HBox(8);
        hBoxConnect.getChildren().addAll(connectionstate,btnConnect,btnSendComand1,btnSendComand2,btnSendComand3);

        VBox vBoxleft = new VBox(8);
        vBoxleft.getChildren().addAll(btnNewUnit, unitlistView, hBoxConnect, lblFeedback, btnSaveUnits, btnRestorUnits);

        VBox vBoxright = new VBox(8);
        vBoxright.getChildren().addAll(comboVendorUnits,unitName, ipAdrHBox, wifissid, wifipword);

        HBox hBox = new HBox(8);
        hBox.getChildren().addAll(vBoxleft,vBoxright);
        hBox.setPadding(new Insets(5));

        Scene scene = new Scene(hBox, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect to Arduino!");
        primaryStage.show();
    }
}

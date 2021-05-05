package ch.zhaw.eigeneProjekte.modularbeit.logSystem.maingui;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
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
import java.util.List;

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
        unitlistView.setPrefWidth(600);


        Button btnNewUnit = new Button("Add new Unit");
        btnNewUnit.setVisible(false);

        Button btnSaveUnits = new Button("Safe Units");
        Button btnRestorUnits = new Button("Restor Units");


        String[] units = { Units.ARDUINO.toString(), Units.RASPBERRY.toString()};
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

        EventHandler newUnitEvent = event -> {
            String ipAdress = ipAdress1.getText() + "." + ipAdress2.getText() + "." +ipAdress4.getText() + "." +ipAdress4.getText();
            InetAddress inetadr;
            try {
                inetadr = Inet4Address.getByName(ipAdress);
                if (comboVendorUnits.getSelectionModel().getSelectedItem().equals(Units.ARDUINO.toString())) {
                    UnitArduino newUnit = new UnitArduino(unitName.getText(),inetadr, wifissid.getText(), wifipword.getText());
                    unitHandler.addUnit(newUnit);
                    obsUnits.add(newUnit.getUnitName());
                } else if(comboVendorUnits.getSelectionModel().getSelectedItem().equals(Units.RASPBERRY.toString()))  {
                    UnitRaspberry newUnit = new UnitRaspberry(unitName.getText(),inetadr, wifissid.getText(), wifipword.getText());
                    unitHandler.addUnit(newUnit);
                    obsUnits.add(newUnit.getUnitName());
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        };
        btnNewUnit.setOnAction(newUnitEvent);


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

        btnSaveUnits.setOnAction(event -> unitHandler.writeUnitsIntoFile());
        btnRestorUnits.setOnAction(event -> {

            unitHandler.readUnitsOfFile();
            obsUnits.clear();
            for (LoggingUnit oneUnit : unitHandler.getUnitSet()) {
                obsUnits.add(oneUnit.getUnitName());
            }
        });


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

        btnConnect.setOnAction(event -> {
            if (myChosenUnit != null) {
                if (!myChosenUnit.isConnected()) {
                    //connect
                    if (myChosenUnit.connect()) {
                        connectionstate.setFill(Color.GREEN);
                        btnConnect.setText("disconnect");
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
                    }
                }
            }

        });

        HBox hBoxConnect = new HBox(8);
        hBoxConnect.getChildren().addAll(connectionstate,btnConnect);

        VBox vBoxleft = new VBox(8);
        vBoxleft.getChildren().addAll(btnNewUnit, unitlistView, hBoxConnect, btnSaveUnits, btnRestorUnits);

        VBox vBoxright = new VBox(8);
        vBoxright.getChildren().addAll(comboVendorUnits,unitName, ipAdrHBox, wifissid, wifipword);

        HBox hBox = new HBox(8);
        hBox.getChildren().addAll(vBoxleft,vBoxright);

        /*Label lblConnection = new Label("no connection");
        TextField txtFIpAdress = new TextField("192.168.0.101");

        Button btnConnect = new Button("Connect...");

        Button btnCommand1 = new Button("cmd 1");
        Button btnCommand2 = new Button("cmd 2");
        Button btnCommand3 = new Button("cmd 3");

        Label lblFeedback = new Label(" --- ");

        //Action of button Connect
        btnConnect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!deviceConnected) {
                    device = new SocketClient();
                    deviceConnected = device.connectDevice(txtFIpAdress.getText());
                    System.out.println("Connectionstate of Connect: " + deviceConnected);
                    if (deviceConnected) {
                        lblConnection.setText("connected");
                        btnConnect.setText("Disconnect...");
                    };
                } else {
                    if (device != null) {
                        deviceConnected = (!device.disconnectDevice());
                        System.out.println("Connectionstate of disconnect: " + deviceConnected);
                        if (!deviceConnected) {
                            lblConnection.setText("no connection");
                            btnConnect.setText("Connect...");
                        };
                    }
                }
            }
        });

        //Action of button Command's
        btnCommand1.setOnAction(event -> {
            if (device != null) {
                device.sendCommand(1);
                String str = Integer.toString(device.readCommand());
                lblFeedback.setText(str);
            }
        });
        btnCommand2.setOnAction(event -> {
            if (device != null) {
                device.sendCommand(2);
                lblFeedback.setText(Integer.toString(device.readCommand()));
            }
        });
        btnCommand3.setOnAction(event -> {
            if (device != null) {
                device.sendCommand(3);
                lblFeedback.setText(Integer.toString(device.readCommand()));
            }
        });


        HBox hbox = new HBox(8);
        hbox.getChildren().addAll(btnCommand1,btnCommand2,btnCommand3);

        VBox vbox = new VBox(8);
        vbox.getChildren().addAll(lblConnection, txtFIpAdress, btnConnect,hbox, lblFeedback);
*/
        Scene scene = new Scene(hBox, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect to Arduino!");
        primaryStage.show();
    }
}

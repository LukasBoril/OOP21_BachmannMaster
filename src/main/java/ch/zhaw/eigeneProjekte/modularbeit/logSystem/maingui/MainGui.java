package ch.zhaw.eigeneProjekte.modularbeit.logSystem.maingui;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import ch.zhaw.eigeneProjekte.modularbeit.logSystem.logSystem.*;
import ch.zhaw.eigeneProjekte.modularbeit.logSystem.units.*;

public class MainGui extends Application {


    //public static void main(String[] args) {
    //    launch(args);
    //}

    public void start(Stage primaryStage) {
        UnitHandler unitHandler = new UnitHandler();

        ObservableList<LoggingUnit> obsUnits = FXCollections.observableList(new UnitHandler().getUnitSet());
        ListView<LoggingUnit> listView = new ListView<>(obsUnits);

        Button btnNewUnit = new Button("Add new Unit");

        Button btnSaveUnits = new Button("Safe Units");
        Button btnRestorUnits = new Button("Restor Units");


        String[] units = { "Arduino", "Raspberry"};
        ObservableList<String> diffUnits = FXCollections.observableArrayList(units);
        ComboBox<String> comboUnits = new ComboBox<>(diffUnits);

        TextField unitName = new TextField("unit-name");
        TextField ipAdress = new TextField("ip-Adress");

        EventHandler newUnitEvent = new EventHandler() {
            @Override
            public void handle(Event event) {
                if (comboUnits.getSelectionModel().getSelectedItem() == "Arduino") {
                    UnitArduino newUnit = new UnitArduino(unitName.getText());
                    obsUnits.add(newUnit);
                } else {
                    UnitRaspberry newUnit = new UnitRaspberry(unitName.getText());
                    obsUnits.add(newUnit);
                }
            }
        };
        btnNewUnit.setOnAction(newUnitEvent);

        btnSaveUnits.setOnAction(event -> unitHandler.writeUnitsIntoFile());
        btnRestorUnits.setOnAction(event -> unitHandler.readUnitsOfFile());

        VBox vBoxleft = new VBox(8);
        vBoxleft.getChildren().addAll(btnNewUnit, listView, btnSaveUnits, btnRestorUnits);

        VBox vBoxright = new VBox(8);
        vBoxright.getChildren().addAll(comboUnits,unitName, ipAdress);

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

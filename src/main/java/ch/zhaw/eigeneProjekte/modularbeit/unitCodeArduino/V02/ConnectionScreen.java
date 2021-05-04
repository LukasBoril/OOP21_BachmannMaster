package ch.zhaw.eigeneProjekte.modularbeit.unitCodeArduino.V02;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConnectionScreen extends Application {
    private boolean deviceConnected;
    private SocketClient device;

    /*
    constructor
     */
    public void ConnectionScreen() {
         deviceConnected = false;
         device = null;
    }

    public void start(Stage primaryStage) {
        Label lblConnection = new Label("no connection");
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

        Scene scene = new Scene(vbox, 200, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect to Arduino!");
        primaryStage.show();
    }
}

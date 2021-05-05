package ch.zhaw.eigeneProjekte.modularbeit.logSystem.logSystem;


import java.io.IOException;
import java.net.Socket;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * This Class ist the Superclass of all the differend EnumUnits,
 * it handles the connection / comands to the Unit / feedback, errors and the datestream from the Unit
 * @author M.Gasser
 * @version 1.000  04.05.2021
 */
public abstract class LoggingUnit implements Serializable {
    private static final long serialVersionID = 1L;

    private static final int serverPortNumber = 80;
    
    private String unitName;
    private boolean connected;

    private Socket clientSocket;

    //Constructor
    public LoggingUnit(String unitName) {
        this.unitName = unitName;
        this.connected = false;
        this.clientSocket = null;
    }

    /**
     * Methode to get the Unit name
     * @return  unitName (as String)
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * Methode to get the Connectionstate (True= connected / false= disconected)
     * @return  connected (as boolean)
     */
    public boolean isConnected() {
        return connected;
    }

    /**
     * Methode to get the get the IP-Adress of the Unit
     * @return  IP-Adress (as InetAddress)
     */
    public abstract InetAddress getIpAdress();

    /**
     * Methode tries to build up a connection to the Unit
     * @return connectionstate true=connected / false=disconnected (as boolean)
     */
    public boolean connect() {
        if (!isConnected()) {
            //Client Socket erzeugen, incl. Verbindungsanfrage
            try {
                clientSocket = new Socket("192.168.0.102",80);//getIpAdress().toString(), serverPortNumber);
                setConnectionState(clientSocket.isBound() && !clientSocket.isClosed());
                System.out.println("Connectionstate of Connect: " + isConnected());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return isConnected();
    }

    /**
     * Methode disconnects the connection to the Unit
     * @return connectionstate true=connected / false=disconnected (as boolean)
     */
    public boolean disconnect() {
        if (isConnected()) {
            try{
                clientSocket.close();
                setConnectionState(!clientSocket.isClosed());
                System.out.println("Connectionstate of Connect: " + isConnected());
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return isConnected();
    }

    /*
    * methode sets the connectionstates
    * @param connectionstate true=connected / false=disconnected (as boolean)
     */
    private void setConnectionState(boolean connected) {
        this.connected = connected;
    }
}

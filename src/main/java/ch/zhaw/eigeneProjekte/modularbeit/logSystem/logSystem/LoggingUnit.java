package ch.zhaw.eigeneProjekte.modularbeit.logSystem.logSystem;


import java.io.*;
import java.net.Socket;

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
    private PrintWriter writer;
    private InputStreamReader streamReader;

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
                System.out.println("Try to connect to Server at IP-Adress: " + getIpAdress().toString().substring(1));
                clientSocket = new Socket(getIpAdress().toString().substring(1), serverPortNumber); //"192.168.0.102",80);
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
     * @return connectionstate: true=connected / false=disconnected (as boolean)
     */
    public boolean disconnect() {
        if (isConnected()) {
            try{
                //writer.close();
                //reader.close();
                clientSocket.close();
                setConnectionState(!clientSocket.isClosed());
                System.out.println("Connectionstate of Connect: " + isConnected());
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return isConnected();
    }

    /**
     * Methode sends a command number to the Unit
     * @param commandNo that has to be sent to the unit (as int)
     * @return writer state: true=all allright / false=Error occured or not unit connected (as boolean)
     */
    public boolean sendCommand(int commandNo) {
        if (isConnected()) {
            //in Socket schreiben
            try {
                writer = new PrintWriter(clientSocket.getOutputStream());
                writer.println(commandNo);
                //writer.close();
                System.out.println("Kommando an Server gesendet: " + commandNo);
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                System.out.println("Error? " + writer.checkError());
                return !writer.checkError();
            }
        }
        return false;
    }

    /**
     * Methode reads the feedback of a command, after a command has been sent to the Unit
     * @return writer state: true=all allright / false=Error occured or not unit connected (as boolean)
     */
    public int readCommandFeedback() {
        int feedback = -1;

        if (isConnected()) {
            //in Socket schreiben
            try {
                streamReader = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                //Meldung lesen
                feedback = (int)reader.read();
                //reader.close();
                System.out.println("Feedback von Server bekommen: " + feedback);
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                return feedback;
            }
        }
        return feedback;
    }

    /*
    * methode sets the connectionstates
    * @param connectionstate true=connected / false=disconnected (as boolean)
     */
    private void setConnectionState(boolean connected) {
        this.connected = connected;
    }
}

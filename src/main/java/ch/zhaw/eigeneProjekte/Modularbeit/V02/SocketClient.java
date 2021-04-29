package ch.zhaw.eigeneProjekte.Modularbeit.V02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    private Socket s;
    private PrintWriter writer;
    private InputStreamReader streamReader;

    /*
    Konstruktor
     */
    public SocketClient() {
        s = null;
        writer = null;
    }

    public boolean connectDevice(String ipAdress) {
        //Client Socket erzeugen, incl. Verbindungsanfrage
        try {
            s = new Socket(ipAdress, 80);
            //vom Socket lesen
            /*InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            //Meldung lesen
            String advice = reader.readLine();
            System.out.println("Ratschlag fuer heute: " + advice);
            reader.close();*/

        } catch(IOException ex) {
            ex.printStackTrace();
        }

        return s.isBound();
    }

    public boolean disconnectDevice() {
            try{
                s.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        return s.isClosed();
    }

    public boolean sendCommand(int commandNo) {
        if (s != null && s.isBound() && !s.isClosed()) {
            //in Socket schreiben
            try {
                writer = new PrintWriter(s.getOutputStream());
                writer.println(commandNo);
                //writer.close();
                System.out.println("Kommando an Server gesendet: " + commandNo);
                //System.out.println("Error? " + writer.checkError());
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                return writer.checkError();
            }
        }
       return false;
    }

    public int readCommand() {
        //vom Socket lesen
        int feedback = -1;
        if (s != null && s.isBound() && !s.isClosed()) {
            try {
                streamReader = new InputStreamReader(s.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                //Meldung lesen
                feedback = reader.read();
                System.out.println("bekommenes Feedback: " + feedback);
                //reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                return feedback;
            }
        }
        return feedback;
    }
}
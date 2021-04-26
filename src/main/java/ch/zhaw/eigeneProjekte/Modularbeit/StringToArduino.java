package ch.zhaw.eigeneProjekte.Modularbeit;

import java.io.*;
import java.net.Socket;

public class StringToArduino {

    public void los() {
        try (Socket s = new Socket("192.168.1.176", 80)) {
            System.out.println("Ergebniss: " + readOfServer(s));


            writeToServer("Hello Server.",s);

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StringToArduino client = new StringToArduino();
        client.los();
    }

    public String readOfServer(Socket s) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
        BufferedReader reader = new BufferedReader(streamReader);

        String serverfeedback = reader.readLine();
        //reader.close();

        return serverfeedback;
    };

    public void writeToServer(String text, Socket s) throws IOException {
        OutputStreamWriter streamWriter = new OutputStreamWriter(s.getOutputStream());
        BufferedWriter writer = new BufferedWriter(streamWriter);

        writer.write(text);
        //writer.close();
    };

}
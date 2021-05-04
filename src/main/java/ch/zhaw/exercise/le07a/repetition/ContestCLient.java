package ch.zhaw.exercise.le07a.repetition;

import ch.zhaw.exercise.le05b.task4.TippDesTagesClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ContestCLient {
    private String advice;

        public void los() {
            //Client Socket erzeugen, incl. Verbindungsanfrage
            try (Socket s = new Socket("united-portal.com", 9998)) {
                //vom Socket lesen
                InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                //Meldung lesen
                this.advice = reader.readLine();
                System.out.println("Die Frage vom Server lautet: " + this.advice);
                reader.close();
            } catch(IOException ex) {
                ex.printStackTrace();
            }



            //Client Socket erzeugen, incl. Verbindungsanfrage
            try (Socket socket2 = new Socket("united-portal.com", 9999);
                 PrintWriter writer = new PrintWriter(socket2.getOutputStream()) ) {
                writer.print("M.Gasser: Super funktioniert");

            } catch (IOException e) {
                e.printStackTrace();
            }


        }



        public static void main(String[] args) {
            ContestCLient client = new ContestCLient();
            client.los();
        }
}

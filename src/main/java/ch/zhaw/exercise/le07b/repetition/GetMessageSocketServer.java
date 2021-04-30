package ch.zhaw.exercise.le07b.repetition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GetMessageSocketServer {
    public void go(){
        try (Socket s = new Socket("united-portal.com", 9998)){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String advice = bufferedReader.readLine();
            System.out.println("Die Frage lautet: " + advice);

        } catch (IOException e){
            e.printStackTrace();
        }

        try (Socket s2 = new Socket("united-portal.com", 9999)) {
            PrintWriter writer = new PrintWriter(s2.getOutputStream());
            writer.print("test");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GetMessageSocketServer client = new GetMessageSocketServer();
        client.go();
    }
}


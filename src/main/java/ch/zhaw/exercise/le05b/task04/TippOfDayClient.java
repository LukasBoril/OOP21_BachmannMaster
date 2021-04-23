package ch.zhaw.exercise.le05b.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TippOfDayClient {

    public void run(){
        try (Socket s = new Socket("127.0.0.1", 4242)){
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(streamReader);

            String advice = bufferedReader.readLine();
            System.out.println("Ratschlag für heute: " + advice);

            bufferedReader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TippOfDayClient client = new TippOfDayClient();
        client.run();
    }
}

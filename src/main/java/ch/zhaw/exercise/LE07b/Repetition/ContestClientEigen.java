package ch.zhaw.exercise.LE07b.Repetition;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ContestClientEigen {
    public void los() {
/*        try (Socket s = new Socket("united-portal.com", 9998)) {

            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            String question = reader.readLine();
            System.out.println("Die Frage lautet " + question);

            reader.close();

        } catch(IOException ex) {
            ex.printStackTrace();
        }*/

        try (Socket s2 = new Socket("united-portal.com", 9999);

            PrintWriter writer = new PrintWriter(s2.getOutputStream())) {
           writer.print("scheint zu funktionieren");

            } catch(IOException ex){
                ex.printStackTrace();
            }
        }


    public static void main(String[] args) {
        ContestClientEigen c = new ContestClientEigen();
        c.los();
    }
}


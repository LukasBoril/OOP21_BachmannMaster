package ch.zhaw.exercise.le05b.task3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TippDesTagesServer {
    String[] tippListe = {
            "Nehmen Sie kleinere Bissen zu sich.",
            "Holen Sie sich die engen Jeans. Nein, Sie sehen darin NICHT dick aus.",
            "Mit einem Wort: unmoeglich!",
            "Seien Sie ehrlich, nur heute mal. Sagen Sie Ihrem Boss, was Sie *wirklich* denken.",
            "Vielleicht wollen Sie doch noch mal über diesen Haarschnitt nachdenken."
    };
    public void los(){
        try (
                ServerSocket serverSock = new ServerSocket(4242)) {
            while (true) {
                Socket sock = serverSock.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());

                writer.println(getTipp());

                writer.close();
                System.out.println(getTipp());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private String getTipp() {

            int random = (int) (Math.random() * tippListe.length);
            return tippListe[random];

    }

    public static void main(String[] args) {
        TippDesTagesServer server = new TippDesTagesServer();
        server.los();

    }

}

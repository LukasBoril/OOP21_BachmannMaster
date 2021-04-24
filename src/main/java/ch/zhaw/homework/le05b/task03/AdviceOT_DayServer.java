package ch.zhaw.homework.le05b.task03;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AdviceOT_DayServer {

    String[] tippListe = {
            "Nehmen Sie kleinere Bissen zu sich.",
            "Holen Sie sich die engen Jeans. Nein, Sie sehen darin NICHT dick aus.",
            "Mit einem Wort: unmoeglich!",
            "Seien Sie ehrlich, nur heute mal. Sagen Sie Ihrem Boss, was Sie *wirklich* denken.",
            "Vielleicht wollen Sie doch noch mal über diesen Haarschnitt nachdenken."
    };

    public void run() {

        try (
                ServerSocket serverSock = new ServerSocket(4242)) {
            while (true) {
                Socket sock = serverSock.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String tipp = getTipp();
                writer.println(tipp);
                writer.close();
                System.out.println(tipp);
            }
        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getTipp() {
        int ran = (int) (Math.random() * tippListe.length);
        return tippListe[ran];
    }

    public static void main(String[] args) {
        AdviceOT_DayServer server = new AdviceOT_DayServer();
        server.run();
    }
}

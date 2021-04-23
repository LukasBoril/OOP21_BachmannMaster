package ch.zhaw.exercise.le05b.task03;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;


public class TippOfDayServer {

        String[] tippList = {"Nehmen Sie kleinere Bissen zu sich.",
                "Holen Sie sich die engen Jeans. Nein, Sie sehen darin NICHT dick aus.",
                "Mit einem Wort: unmoeglich!",
                "Seien Sie ehrlich, nur heute mal. Sagen Sie Ihrem Boss, was Sie *wirklich* denken.",
                "Vielleicht wollen Sie doch noch mal über diesen Haarschnitt nachdenken."
        };

    public void run(){
        try (ServerSocket serverSocket = new ServerSocket(4242)){

            while (true){
                Socket socket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String tipp = getTipp();
                writer.println(tipp);
                writer.close();
                System.out.println(tipp);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private String getTipp(){
        return tippList[new Random().nextInt(tippList.length)];
    }

    public static void main(String[] args) {
        TippOfDayServer server = new TippOfDayServer();
        server.run();
    }
}

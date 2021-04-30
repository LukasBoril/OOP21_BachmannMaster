package ch.zhaw.exercise.le07b.task01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class JavaWebServer {

    private static final int fNumberOfThreads = 100;
    private static final Executor fThreadPool = Executors.newFixedThreadPool(fNumberOfThreads);

    public static void main(String[] args) {

        System.setProperty("java.net.preferIPv4Stack", "true");

        try (ServerSocket socket = new ServerSocket(8080)) {
            System.out.println("open browser and enter url: http://localhost:8080");

            while (true) {
                System.out.println("wait for accept");

                final Socket connection = socket.accept();

                System.out.println("connection request found");

                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Task " + Thread.currentThread().getName());
                        handleRequest(connection);
                        try {
                            connection.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                fThreadPool.execute(task);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket socket) {

        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)){
            String webServerAddress = socket.getInetAddress().toString();
            System.out.println("New Connection: " + webServerAddress);

            printHeader(socket);

            out.println("HTTP/1.0 200");
            out.println("Content-type: text/html");
            out.println("Server-name: myJavaServer");

            String response = "<html>\n "
                    + "<head>\n" + "<title>My Java Web Server</title></head>\n"
                    + "<h1>Welcome to my Java Web Server! </h1>\n"
                    + "<p>Server Time: " + getCurrentTimeStamp()
                    + "</p>\n" + "</html>\n";

            out.println("Content-length: " + response.length());
            out.println("");
            out.println(response);
            out.flush();

            socket.close();

        } catch (IOException e) {
            System.out.println("Failed to respond to client request: " + e.getMessage());
        }
    }

    private static void printHeader(Socket socket){
        int c;
        StringBuffer raw = new StringBuffer();

        try {
            do {
                c = socket.getInputStream().read();
                raw.append((char) c);
            } while (socket.getInputStream().available() > 0);
            System.out.println(raw.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getCurrentTimeStamp(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        return simpleDateFormat.format(now);
    }
}

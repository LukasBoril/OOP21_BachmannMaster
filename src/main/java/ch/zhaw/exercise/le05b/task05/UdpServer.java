package ch.zhaw.exercise.le05b.task05;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UdpServer {
    public static void main(String[] args) {
        int portNr = 9876;

        try (DatagramSocket socket = new DatagramSocket(portNr)){
            System.out.println("Datagram Socket PORT Nr.: " + portNr);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

            while (true){
                DatagramPacket packet = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(packet);

                String sentence = new String(packet.getData());
                System.out.println("RECEIVED: " + sentence);

                InetAddress IpAddress = packet.getAddress();
                int port = packet.getPort();

                String capitalizedSentence = sentence.toUpperCase();
                sendData = capitalizedSentence.getBytes(StandardCharsets.UTF_8);
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IpAddress, port);
                socket.send(sendPacket);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("DatagramSocket wurde geschlossen");
    }
}

package ch.zhaw.exercise.LE05b.Task05;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String args[]) throws Exception {
        int portNr = 9876;
        try (DatagramSocket serverSocket = new DatagramSocket(portNr)) {
            System.out.println("DatagramSocket PORT nr " + portNr);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String sentence = new String(receivePacket.getData());
                System.out.println("RECEIVED: " + sentence);

                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();

                String capitalizedSentence = sentence.toUpperCase();
                sendData = capitalizedSentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                serverSocket.send(sendPacket);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("DatagramSocket wurde geschlossen");
    }
}

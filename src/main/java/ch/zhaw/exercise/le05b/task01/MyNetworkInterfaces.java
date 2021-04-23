package ch.zhaw.exercise.le05b.task01;

import java.net.*;
import java.util.Enumeration;

public class MyNetworkInterfaces {

    public static void main(String[] args) {

        try {
            Enumeration<NetworkInterface> interfaceEnumeration = NetworkInterface.getNetworkInterfaces();

            while (interfaceEnumeration.hasMoreElements()){
                NetworkInterface iface = interfaceEnumeration.nextElement();
                System.out.println("Interface " + iface.getName() + ":");
                Enumeration<InetAddress> addressEnumeration = iface.getInetAddresses();

                if (addressEnumeration.hasMoreElements()){
                    InetAddress address = addressEnumeration.nextElement();

                    String ip = ((address instanceof Inet4Address ? "(v4) "
                            : (address instanceof Inet6Address ? "(v6) " : "(?) ")));

                    System.out.println("\tAddress " + ip + " " + address.getHostAddress());
                }
            }
        } catch (SocketException se){
            System.out.println("Error getting network interfaces: " + se.getMessage());
        }
    }
}

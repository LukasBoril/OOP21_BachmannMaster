package ch.zhaw.homework.le05b.task01;

import java.net.*;
import java.util.Enumeration;

public class MyNetworkInterfaces {
    public static void main(String[] args) {
// System.setProperty("java.net.preferIPv4Stack", "true");
        try {
            Enumeration<NetworkInterface> interfaceList =
                    NetworkInterface.getNetworkInterfaces();
            while (interfaceList.hasMoreElements()) {
                NetworkInterface iface = interfaceList.nextElement();
                System.out.println("Interface " + iface.getName() + ":");
                Enumeration<InetAddress> addrList = iface.getInetAddresses();
// get list of *all* IPs
                if (!addrList.hasMoreElements()) {
                    System.out.println("\t(No addresses for this interface)");
                }
                while (addrList.hasMoreElements()) {
// extract a single IP from the list of IPs
                    InetAddress address = addrList.nextElement();
// identify address type
                    String ip = ((address instanceof Inet4Address ? "(v4) "
                            : (address instanceof Inet6Address
                            ? "(v6) " : "(?)")));
                    System.out.println("\tAddress " + ip + " " + address.getHostAddress());
                }
            }
        } catch (SocketException se) {
            System.out.println("Error getting network interfaces:" + se.getMessage());
        }
    }
}

package ch.zhaw.exercise.LE05b.Task02;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SimpleNameLookup {
    public static void main(String[] args) {
        String[] hosts = {"www.zhaw.ch", "www.sbb.ch"};
        for (String host : hosts) {
            try {
                System.out.println(host + ":");
                InetAddress[] addressList = InetAddress.getAllByName(host);
                // Name-to-IP, many IPs to one name is possible
                for (InetAddress address : addressList) {
                    System.out.println("\t" + address.getHostName() + " -> " +
                            address.getHostAddress());
                }
            } catch (UnknownHostException e) {
                System.out.println("\t Unable to find address for " + host);
            }
        }
    }
}

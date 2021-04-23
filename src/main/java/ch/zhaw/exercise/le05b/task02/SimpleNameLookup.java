package ch.zhaw.exercise.le05b.task02;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SimpleNameLookup {
    public static void main(String[] args) {
        String[] hosts = {"www.zhaw.ch", "www.sbb.ch"};
        for (String host : hosts){
            try {
                System.out.println(host + ":");
                InetAddress[] addresses = InetAddress.getAllByName(host);

                for (InetAddress address : addresses){
                    System.out.println("\t" + address.getHostName() + "->" + address.getHostAddress());
                }
            } catch (UnknownHostException e){
                System.out.println("\t Unable to find address for " + host);
            }
        }
    }
}

package ch.zhaw.eigeneProjekte.modularbeit.logSystem.logSystem;

import java.net.InetAddress;

/**
 * This Interface shold be implemented into those EnumUnits that shall be able to connect with Wifi.
 * @author M.Gasser
 * @version 1.000  05.05.2021
 */
public interface WifiInterface {

    /**
     * Methode to get the get the IP-Adress of the Unit
     * @return  IP-Adress (as InetAddress)
     */
    InetAddress getIpAdress();

    /**
     * Methode to get the get the ssid of the wifi to connect the Unit with
     * @return  Wifi-SSID (as String)
     */
    String getWifissid();

    /**
     * Methode to read the get the password of the wifi to connect the Unit with
     * @return  Wifi-Password (as String)
     */
    String getWifiPassword();
}

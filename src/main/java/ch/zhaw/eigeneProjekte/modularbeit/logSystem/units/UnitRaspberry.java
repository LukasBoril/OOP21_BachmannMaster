package ch.zhaw.eigeneProjekte.modularbeit.logSystem.units;

import ch.zhaw.eigeneProjekte.modularbeit.logSystem.logSystem.LoggingUnit;
import ch.zhaw.eigeneProjekte.modularbeit.logSystem.logSystem.WifiInterface;

import java.io.Serializable;
import java.net.InetAddress;


/**
 * This Class ist the Subclass of LoggingUnit and is for the Raspberry Unit,
 * it handles the connection / comands to the Unit / feedback, errors and the datestream from the Unit
 * @author M.Gasser
 * @version 1.000  04.05.2021
 */
public class UnitRaspberry extends LoggingUnit implements WifiInterface, Serializable {
    private static final long serialVersionID = 1L;

    private InetAddress ipAdress;
    private String wifissid;
    private String wifipword;

    //constructor
    public UnitRaspberry(String unitName, InetAddress ipAdress, String wifissid, String wifipword) {
        super(unitName);
        this.ipAdress = ipAdress;
        this.wifissid = wifissid;
        this.wifipword = wifipword;
    }

    /**
     * Methode to get the get the IP-Adress of the Unit
     * @return  IP-Adress (as InetAddress)
     */
    @Override
    public InetAddress getIpAdress() {
        return ipAdress;
    }

    /**
     * Methode to get the get the ssid of the wifi to connect the Unit with
     * @return  Wifi-SSID (as String)
     */
    @Override
    public String getWifissid() {
        return wifissid;
    }

    /**
     * Methode to read the get the password of the wifi to connect the Unit with
     * @return  Wifi-Password (as String)
     */
    @Override
    public String getWifiPassword() {
        return wifipword;
    }
}

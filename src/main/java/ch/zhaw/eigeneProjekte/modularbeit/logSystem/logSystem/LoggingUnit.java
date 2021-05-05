package ch.zhaw.eigeneProjekte.modularbeit.logSystem.logSystem;


import java.io.Serializable;

/**
 * This Class ist the Superclass of all the differend Units,
 * it handles the connection / comands to the Unit / feedback, errors and the datestream from the Unit
 * @author M.Gasser
 * @version 1.000  04.05.2021
 */
public abstract class LoggingUnit implements Serializable {
    private static final long serialVersionID = 1L;

    private String unitName;
    private boolean connected;

    //Constructor
    public LoggingUnit(String unitName) {
        this.unitName = unitName;
        this.connected = false;
    }

    /**
     * Methode to get the Unit name
     * @return  unitName (as String)
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * Methode to get the Connectionstate (True= connected / false= disconected)
     * @return  connected (as boolean)
     */
    public boolean isConnected() {
        return connected;
    }

    /**
     * Methode tries to build up a connection to the Unit
     * @return connectionstate true=connected / false=disconnected (as boolean)
     */
    public boolean connect() {
        connected = true;

        return isConnected();
    }

    /**
     * Methode disconnects the connection to the Unit
     * @return connectionstate true=connected / false=disconnected (as boolean)
     */
    public boolean disconnect() {
        connected = false;

        return isConnected();
    }
}

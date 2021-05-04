package ch.zhaw.eigeneProjekte.modularbeit.logSystem.units;

import ch.zhaw.eigeneProjekte.modularbeit.logSystem.logSystem.LoggingUnit;
import ch.zhaw.eigeneProjekte.modularbeit.logSystem.logSystem.WifiInterface;


/**
 * This Class ist the Subclass of LoggingUnit and is for the Arduino Unit,
 * it handles the connection / comands to the Unit / feedback, errors and the datestream from the Unit
 * @author M.Gasser
 * @version 1.000  04.05.2021
 */
public class UnitArduino extends LoggingUnit implements WifiInterface {
    private int testVar1;

    //constructor
    public UnitArduino(String unitName) {
        super(unitName);
        this.testVar1 = 1;
    }

}

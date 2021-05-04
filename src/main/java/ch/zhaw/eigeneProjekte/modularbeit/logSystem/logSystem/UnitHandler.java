package ch.zhaw.eigeneProjekte.modularbeit.logSystem.logSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;


/**
 * This Class holds all the added Units and gives methodes to add/ remove a certain Unit.
 * Also it reads/writes the holded Units into a Project file if asked for.
 * @author M.Gasser
 * @version 1.000  04.05.2021
 */
public class UnitHandler {
    private static String pathToPackage = "src/main/java/ch.zhaw/eigeneProjekte/modularbeit/logSystem/files/";
    private static File file = new File(pathToPackage + "MyUnits.txt");


    private ArrayList<LoggingUnit> myUnits;//HashSet<LoggingUnit> myUnits; eng_gam wieder auf HashSet zurücksetzen


    //Constructor
    public UnitHandler() {
        this.myUnits = new ArrayList<>();
    }

    /**
     * Methode to add a new Unit to the HashSet
     * It gives the feedback if it got fullfilled or not
     * @param  newUnit (as LoggingUnit)
     * @return  fullfilled (as boolean)
     */
    public boolean addNUnit(LoggingUnit newUnit) {
        if (newUnit != null){
            this.myUnits.add(newUnit);
            return true;
        }
        return false;
    }

    /**
     * Methode to remove a Unit of to the HashSet.
     * It gives the feedback if it got fullfilled or not
     * @param  choosenUnit (as LoggingUnit)
     * @return  fullfilled (as boolean)
     */
    public boolean removeUnit(LoggingUnit choosenUnit) {
        if (choosenUnit != null && this.myUnits.contains(choosenUnit)) {
            this.myUnits.remove(choosenUnit);
            return true;
        }
        return false;
    }

    /**
     * Methode to give out the whole HashSet.
     */
    public ArrayList<LoggingUnit> getUnitSet() {
        return myUnits;
    }

    /**
     * Methode writes all the Units of the HashSet into a file, to be able to restore it sometime later.
     */
    public void writeUnitsIntoFile() {

        if (myUnits.size() > 0) {
            try (OutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                System.out.println("Following Objects got written into file:");
                for (LoggingUnit oneUnit : myUnits) {
                    oos.writeObject(oneUnit);
                    System.out.println(oneUnit.getUnitName());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Methode reads all the Units out of the file and restores the HashSet with it.
     */
    public void readUnitsOfFile() {

        try (InputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)){


            myUnits = (ArrayList<LoggingUnit>) ois.readObject();

            System.out.println("Following Objects got read out of the file:");
            for (LoggingUnit oneUnit : myUnits) {
                System.out.println(oneUnit.getUnitName());
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }
}

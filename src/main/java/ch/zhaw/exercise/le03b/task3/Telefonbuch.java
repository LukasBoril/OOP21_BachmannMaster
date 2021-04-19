package ch.zhaw.exercise.le03b.task3;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Telefonbuch {
    private final Map<String, String> telBuch;

    public Telefonbuch() {
        this.telBuch = new TreeMap<>();
    }

    public void addEntry(String name, String number) throws NotValidEntryException,NotValidPhoneNumber {
        if (name == null || number == null || name.isEmpty() || number.isEmpty()) {
            throw new NotValidEntryException("ein Parameter ist null oder leer!");
        } else if (number == "555") {
            throw new NotValidPhoneNumber();
        }
        this.telBuch.put(name, number);
    }

    public String getNumber(String name) {
        return telBuch.get(name);
    }

    public void printTelBuch() {
        for (String key : telBuch.keySet()) {
            System.out.println(key + " " + telBuch.get(key));
        }
    }

    //Mainroutine
    public static void main(String[] args) throws NotValidEntryException,NotValidPhoneNumber {
        Telefonbuch t = new Telefonbuch();
        try {
            t.addEntry("Zora", "48632145");
            t.addEntry("Alfons", "555");
            t.addEntry("Bla", null);
        } catch (NotValidEntryException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (NotValidPhoneNumber e) {
            e.printStackTrace();
        }
        t.printTelBuch();
    }

}

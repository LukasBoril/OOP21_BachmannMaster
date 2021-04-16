package ch.zhaw.exercise.LE03.Task3;

import java.util.Map;
import java.util.TreeMap;

public class Telefonbuch {
    private Map<String, String> telBuch;

    public Telefonbuch(){
        telBuch = new TreeMap<>();
    }

    public void addEntry(String name, String number) throws NotValidEntryException {
        if (name == null || number == null || name.isEmpty() || number.isEmpty()) {
            throw new NotValidEntryException("ein Parameter ist null oder leer");
        }
        telBuch.put(name, number);
    }

    public void printTelBuch(){
        for(String name : telBuch.keySet()) {
            System.out.println(name + " " + telBuch.get(name));
        }
    }

}

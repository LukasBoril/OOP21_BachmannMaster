package ch.zhaw.homework.le03.le03b.task03;

import java.util.Map;
import java.util.TreeMap;

public class Telefonbuch {

    private final Map<String,String> telBuch;

    public Telefonbuch() {
        telBuch = new TreeMap<>();
    }

    public void addEntry(String name, String number) throws NotValidEntryException{

        if (name == null || name.equals("") || number == null || number.equals("")) {
            throw new NotValidEntryException("Parameter ist entweder null oder leer");
        }
        telBuch.put(name, number);
    }

    public void printTelBuch() {
        for ( String key : telBuch.keySet()) {
            System.out.println(key + " " + telBuch.get(key));
        }
    }

    public static void main(String[] args) throws NotValidEntryException {
        Telefonbuch t = new Telefonbuch();
        try {
            t.addEntry("Zora", "123123");
            t.addEntry("Bla", null);
            t.addEntry("Alfons", "987987");

        } catch (NotValidEntryException e) {
            e.printStackTrace();
        }
        t.printTelBuch();
    }
}

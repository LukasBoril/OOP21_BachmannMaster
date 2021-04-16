package ch.zhaw.exercise.le03b.task3;

import java.util.Map;
import java.util.TreeMap;

public class Telefonbuch {

    private Map<String, String> telBuch;

    public Telefonbuch() {
        this.telBuch = new TreeMap<>();
    }

    public void addEntry(String name, String number) throws NotValidEntryException {

        if(name == null || number == null || name.isEmpty() || number.isEmpty()) {
            throw new NotValidEntryException();
        }
        this.telBuch.put(name, number);
    }

    public void printTelBuch() {
        for( String key : telBuch.keySet()){
            System.out.println(key + " " + telBuch.get(key));
        }
    }

    public static void main(String[] args) throws NotValidEntryException {
        Telefonbuch t = new Telefonbuch();
        try {
            t.addEntry("Zora", "123123");
            t.addEntry("Alfons", "987987");
            t.addEntry("Bla", null);
        } catch (NotValidEntryException e) {
            e.printStackTrace();
        }
        t.printTelBuch();
    }

}

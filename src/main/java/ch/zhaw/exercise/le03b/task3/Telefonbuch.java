package ch.zhaw.exercise.le03b.task3;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class Telefonbuch {

    private final Map<String, String> telBuch;

    public Telefonbuch() {
        this.telBuch = new TreeMap<String, String>();
    }

    public void addEntry(String name, String number) throws NotValidEntryException {

        if (name == null || number == null || name.isEmpty() || number.isEmpty()) {
            throw new NotValidEntryException("ein parameter ist null oder leer");
        }
        this.telBuch.put(name, number);
    }

    /**
     * 3 Varianten alle Einträge auszugeben (nur 1 Variante programmieren)
     */
    public void printTelBuch() {

        // Variante 1: for-each-loop ueber set mit key und value
        for (String key : telBuch.keySet()) {
            System.out.println(key + " " + telBuch.get(key));
        }

        // Variante 2:  for-each-loop ueber set mit Entry-Interface
        for (Map.Entry<String, String> entry : telBuch.entrySet()) {
            System.out.println(entry.getKey() + " "
                    + entry.getValue());
        }

        // Variante 3:  while-loop ueber set mit Entry-Interface
        Iterator<Map.Entry<String, String>> iter;
        iter = telBuch.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> e = iter.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

    public String getNumber(String name) {
        return telBuch.get(name);
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

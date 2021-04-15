package ch.zhaw.homework.le01.WissenssicherungL01;

import java.util.ArrayList;
import java.util.Random;

public class AntwortMap {

    private ArrayList<String> standardantworten;
    private Random zufallsgenerator;

    public AntwortMap() {
        standardantworten = new ArrayList<>();
        zufallsgenerator = new Random();
        standardantwortlisteFuellen();
    }

    public void standardantwortlisteFuellen() {
        standardantworten.add("Kino");
        standardantworten.add("Essen gehen ");
        standardantworten.add("In den Migros einkaufen gehen");
        standardantworten.add("Bodensee");
        standardantworten.add("Schwimmbad");
        standardantworten.add("Drei Weiern");
    }

    /*
     * Wähle zufällig eine der Standardantworten aus.
     * @return  eine zufällig gewählte Standardantwort
     */
    public String standardantwortAuswählen() {
        /* Erzeuge eine Zufallszahl, die als Index in der Liste der
        Standardantworten benutzt werden kann. */

        int index = zufallsgenerator.nextInt(standardantworten.size());
        return standardantworten.get(index);
    }
}

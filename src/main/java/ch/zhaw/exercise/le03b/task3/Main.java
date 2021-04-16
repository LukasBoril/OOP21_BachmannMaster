package ch.zhaw.exercise.le03b.task3;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) throws NotValidEntryException {
        Telefonbuch t = new Telefonbuch();
        try {
            t.addEntry("Zora", "123123");
            t.addEntry("Alfons", "987987");
            t.addEntry("Bla", null);
        } catch (NotValidEntryException e) {

            e.printStackTrace();
        }
        t.printPhoneBook();
    }

}

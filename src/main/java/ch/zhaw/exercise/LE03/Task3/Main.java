package ch.zhaw.exercise.LE03.Task3;

public class Main {

    public static void main(String[] args) {
        Telefonbuch t = new Telefonbuch();
        try {
            t.addEntry("Zora", "123123");
            t.addEntry("Alfons", "987987");
            t.addEntry("Bla", null);
        } catch (NotValidEntryException e) {
            e.printStackTrace();
        }
        t.printTelBuch(); }

}

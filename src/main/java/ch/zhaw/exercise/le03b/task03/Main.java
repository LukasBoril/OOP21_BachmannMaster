package ch.zhaw.exercise.le03b.task03;

public class Main {

    public static void main(String[] args) {

        Phonebook t = new Phonebook();
        try{
            t.addEntry("Zora", "123123");
            t.addEntry("Alfons", "987987");
            t.addEntry("Bla", null);
            t.printPhonebook();
        } catch (NotValidEntryException e){
            e.printStackTrace();
        }
    }
}

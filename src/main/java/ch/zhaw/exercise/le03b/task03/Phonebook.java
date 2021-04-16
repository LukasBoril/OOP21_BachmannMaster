package ch.zhaw.exercise.le03b.task03;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Phonebook {

    private Map<String,String> phonebook;

    public Phonebook(){
        phonebook = new TreeMap<>();
    }

    public void addEntry(String name, String number) throws NotValidEntryException{
        if (name == null || number == null){
            throw new NotValidEntryException("Name oder Nummer ist nicht angegeben!");
        }
        this.phonebook.put(name, number);
    }

    public void printPhonebook(){
        Set<Map.Entry<String,String>> entries = phonebook.entrySet();
        entries.forEach(entry -> {
            System.out.println("Person: " + entry.getKey() + " Phonenumber: " + entry.getValue());});

    }
}

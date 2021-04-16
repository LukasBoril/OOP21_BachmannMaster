package ch.zhaw.exercise.le03b.task3;

import org.apache.logging.log4j.core.appender.SyslogAppender;

import java.util.Map;
import java.util.TreeMap;

public class Telefonbuch {

    private Map<String, String> telBook;

    public Telefonbuch(){

        this.telBook = new TreeMap<String, String>();

    }

    public void addEntry(String name, String number) throws NotValidEntryException{
        if (name == null || number == null || name.isEmpty() || number.isEmpty()) {
            throw new NotValidEntryException("ein Parameter ist null oder leer");
        }

        telBook.put(name, number);
    }

    public void printPhoneBook(){

        for (String key : telBook.keySet()){
            System.out.println(key + " " + telBook.get(key));
        }

    }


}

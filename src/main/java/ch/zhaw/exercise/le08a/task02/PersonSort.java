package ch.zhaw.exercise.le08a.task02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person implements Comparable<Person>{

    private final String name;
    private final int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person person) {
        //Loesung 1 nach Alter
        //return this.getAge() - person.getAge();

        //Loesung 2 nach Name
        //return this.getName().compareTo(person.getName());

        //Loesung 3 nach Alter und Name
        if (this.age - person.age == 0) {
            return this.getName().compareTo(person.getName());
        }
        return this.getAge() - person.getAge();
    }
}

public class PersonSort {
    public static void main(String[] args) {
        List<Person> persList = new ArrayList<Person>();

        persList.add(new Person("Hans", 84));
        persList.add(new Person("Anna", 21));
        persList.add(new Person("Stephan", 35));
        persList.add(new Person("Zora", 11));
        persList.add(new Person("Philip", 35));
        Collections.sort(persList);
        for (Person person : persList) {
            System.out.println(person.getAge() + " " + person.getName());
        }
    }
}
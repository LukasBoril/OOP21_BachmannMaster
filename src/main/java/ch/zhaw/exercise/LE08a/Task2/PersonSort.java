package ch.zhaw.exercise.LE08a.Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonSort {
        public static void main(String[] args) {
            List<Person> persList = new ArrayList<Person>();
            persList.add(new Person("Hans1", 84));
            persList.add(new Person("Anna1", 21));
            persList.add(new Person("Stephan", 35));
            persList.add(new Person("Zora", 11));
            persList.add(new Person("Philip", 35));
            Collections.sort(persList);
            for (Person person : persList) {
                System.out.println(person.getAge() + " " + person.getName());
            } }
    }

class Person implements Comparable<Person> {

    private final String name;
    private final int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person (String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if (this.age - o.age == 0){
            return this.name.compareTo(o.name);
        }
        return this.age - o.age;
    }
}

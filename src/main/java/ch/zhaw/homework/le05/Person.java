package ch.zhaw.homework.le05;

import javafx.beans.property.SimpleStringProperty;

public class Person {
    private SimpleStringProperty eMail;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;

    public Person(String firstName, String lastName, String eMail) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.eMail =  new SimpleStringProperty(eMail);
    }

    public void setEMail(String eMail) {
        this.eMail.set(eMail);
    }
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getEmail() {
        return eMail.get();
    }
    public String getFirstName() {
        return firstName.get();
    }
    public String getLastName() {
        return lastName.get();
    }
}

package ch.zhaw.homework.le04.task3;

import java.io.Serializable;

public class Fahrzeug {//implements Serializable {

    private static final long serialVersionUID = 1L;

    private String number;

    public Fahrzeug(){}

    public Fahrzeug(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

package ch.zhaw.homework.le04.task3;

import java.io.Serializable;

public class Vehicle implements Serializable {

    private static final long serialVersionUID = 5929482525477575331L;

    public Vehicle() {

    }

    private String number;

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}

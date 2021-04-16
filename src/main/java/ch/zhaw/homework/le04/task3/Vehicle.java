package ch.zhaw.homework.le04.task3;

import java.io.Serializable;

public class Vehicle implements Serializable {

    private static final long serialVersionUID = 8574829967951488322L;

    private String number;

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}

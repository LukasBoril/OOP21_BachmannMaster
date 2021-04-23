package ch.zhaw.exercise.le04a.task3;

import java.io.Serializable;

public class Fahrzeug implements Serializable {
    protected String nummer;

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }
}

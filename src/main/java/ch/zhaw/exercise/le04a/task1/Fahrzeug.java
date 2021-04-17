package ch.zhaw.exercise.le04a.task1;

import java.io.Serializable;

public class Fahrzeug implements Serializable {
    public static final long serialVersionUID = 1L;

    private String nummer;

    public Fahrzeug() {
    }

    public Fahrzeug(String nummer) {
        this.nummer = nummer;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }
}

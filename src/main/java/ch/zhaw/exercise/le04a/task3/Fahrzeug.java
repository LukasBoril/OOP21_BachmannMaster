package ch.zhaw.exercise.le04a.task3;

import java.io.Serializable;

public class Fahrzeug implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nummer;

    public Fahrzeug() {
    }

    public Fahrzeug(String nummer){

        setNummer(nummer);

    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }
}

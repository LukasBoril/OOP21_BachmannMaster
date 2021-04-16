package ch.zhaw.exercise.LE04.Task4;

import java.io.Serializable;

public class Fahrzeug implements Serializable {

    private static final long serialVerisonUID = 1L;
    private String nummer;

    public Fahrzeug(String nummer){
        this.nummer = nummer;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }
}

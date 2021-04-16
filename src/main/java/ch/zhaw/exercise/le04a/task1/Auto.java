package ch.zhaw.exercise.le04a.task1;

import java.io.Serializable;

public class Auto extends Fahrzeug implements Serializable {

    private static final long serialVersionUID = 1L;
    private String farbe;
    private Motor motor;

    public Auto(Motor motor, String farbe) {
        super("");
        this.farbe = farbe;
        this.motor = motor;
    }

    public Motor getMotor() {
        return motor;
    }

    public String getFarbe() {
        return farbe;
    }
}

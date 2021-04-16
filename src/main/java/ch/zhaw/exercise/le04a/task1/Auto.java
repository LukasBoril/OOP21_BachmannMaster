package ch.zhaw.exercise.le04a.task1;

import java.io.Serializable;

public class Auto implements Serializable {
    private static final long serialVersionID = 1L;

    private Motor motor;
    private String farbe;

    public Auto(Motor motor, String farbe) {
        this.motor = motor;
        this.farbe = farbe;
    }

    public String getFarbe() {
        return farbe;
    }

    public Motor getMotor() {
        return motor;
    }
}

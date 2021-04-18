package ch.zhaw.homework.le04.task3;

import java.io.Serializable;

public class Auto extends Fahrzeug implements Serializable {

    private static final long serialVersionUID = 1L;
    private Motor motor;
    private String farbe;

    public Auto(Motor motor, String farbe) {
        this.motor = motor;
        this.farbe = farbe;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
}

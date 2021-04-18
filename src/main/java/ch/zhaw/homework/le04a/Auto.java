package ch.zhaw.homework.le04a;

import java.io.Serializable;

public class Auto extends Fahrzeug implements Serializable {
    private static final long serialVersionID = 1L;

    private  Motor motor;
    private String farbe;


    public Auto(Motor motor, String farbe) {
        super("");
        this.motor = motor;
        this.farbe = farbe;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
}

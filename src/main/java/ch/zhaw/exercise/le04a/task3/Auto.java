package ch.zhaw.exercise.le04a.task3;

import sun.plugin.javascript.navig.FrameArray;

import java.io.Serializable;

public class Auto extends Fahrzeug implements Serializable {

    private static final long serialVersionUID = 10L;
    private String farbe;
    private Motor motor;

    public Auto(String farbe, Motor motor) {
        super("");
        this.farbe = farbe;
        this.motor = motor;

    }


    public String getFarbe() {
        return farbe;
    }

    public Motor getMotor() {
        return motor;
    }
}

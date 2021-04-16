package ch.zhaw.exercise.LE04.Task4;

import java.io.Serializable;

public class Auto extends Fahrzeug implements Serializable {

    private static final long serialVersionUID = 1L;
    private String farbe;
    private Motor motor;

    public Auto( Motor motor, String farbe){
        super("");
        this.motor = motor;
        this.farbe = farbe;
    }

    public Motor getMotor(){
        return motor;
    }

    public String getFarbe(){
        return farbe;
    }
}

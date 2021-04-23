package ch.zhaw.exercise.le04a.task3;

import java.io.Serializable;

public class Auto extends Fahrzeug implements Serializable {

    private String farbe;
    private Motor motor;
    private static final long serialVersionUID = 2L;

    public Auto(String farbe, Motor motor)
    {
        this.farbe = farbe;
        this.motor = motor;
    }

    public String getFarbe(){
        return farbe;
    }

    public Motor getMotor(){
        return motor;
    }
}

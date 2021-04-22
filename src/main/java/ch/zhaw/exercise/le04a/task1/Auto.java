package ch.zhaw.exercise.le04a.task1;

import java.io.Serializable;

public class Auto extends Fahrzeug implements Serializable {
    private static final long serialVersionID = 3L;

    private Motor motor;
    private String farbe;
    //private transient String farbe; (-> mit transient wird diese Variable nicht serialisiert. bei Unserialize hat sie null)

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

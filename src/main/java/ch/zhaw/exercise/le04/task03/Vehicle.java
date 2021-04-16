package ch.zhaw.exercise.le04.task03;

import java.io.Serializable;

public class Vehicle implements Serializable {

    private static final long serializeVersionUID = 2L;
    private String vehicleNumber;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}

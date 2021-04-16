package ch.zhaw.exercise.le04.task01;

import ch.zhaw.exercise.le04.task03.Vehicle;

public class Car extends Vehicle {

    private String colour;
    private Motor motor;

    public Car(String colour, int motorSize, String vehicleNumber){
        super();
        this.colour = colour;
        this.motor = new Motor(motorSize);
        this.setVehicleNumber(vehicleNumber);
    }

    public String getColour(){
        return colour;
    }

    public int getMotorSize(){
        return motor.getMotorSize();
    }
}

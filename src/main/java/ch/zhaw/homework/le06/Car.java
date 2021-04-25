package ch.zhaw.homework.le06;

import java.util.Random;

public class Car extends Thread{

    private String carName;
    private ParkingGarage parkingGarage;

    public Car(String carName, ParkingGarage parkingGarage){
        this.carName = carName;
        this.parkingGarage = parkingGarage;
    }

    @Override
    public void run() {

        while (true){
            try {
                parkingGarage.enter(this);
                Thread.sleep(new Random().nextInt(10) * 1000);
                parkingGarage.leave(this);
                Thread.sleep(new Random().nextInt(10) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getCarName(){
        return this.carName;
    }
}

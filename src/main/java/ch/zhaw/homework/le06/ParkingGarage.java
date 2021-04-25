package ch.zhaw.homework.le06;

import java.util.ArrayList;
import java.util.List;

public class ParkingGarage {

    private int parkingSpaces;
    private List<Car> cars;

    public ParkingGarage(int parkingSpaces){
        this.parkingSpaces = parkingSpaces;
        this.cars = new ArrayList<>(parkingSpaces);
    }

    public void enter(Car car){

        if (cars.size() < parkingSpaces){
            cars.add(car);
            System.out.println("Auto " + car.getCarName() + ": eingefahren");
        } else {
            System.out.println("Das Parkhaus ist voll");
        }
    }

    public void leave(Car car){
        if (!cars.isEmpty()){
            cars.remove(car);
            System.out.println("Auto " + car.getCarName() + ": ausgefahren");
        } else {
            System.out.println("Das Parkhaus ist leer");
        }
    }
}

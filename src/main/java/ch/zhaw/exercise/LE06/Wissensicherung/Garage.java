package ch.zhaw.exercise.LE06.Wissensicherung;

import java.util.ArrayList;

public class Garage {
    private int parkingLots;
    private ArrayList<Car> cars;

    public Garage(int parkingLots)
    {
        this.parkingLots = parkingLots;
        cars = new ArrayList<>(parkingLots);
    }

    public void enter(Car car) {
        if (cars.size() < parkingLots) {
            cars.add(car);
            System.out.println("Auto " + car.getNumber() + " ist eingefahren");
        }
    }

    public void leave(Car car)
    {
        cars.remove(car);
        System.out.println("Auto " + car.getNumber()+ " ist ausgefahren");
    }
}

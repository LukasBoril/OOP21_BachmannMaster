package ch.zhaw.homework.le06;

public class Parking {

    public static void main(String[] args) {

        int parkingSpaces = 10;

        ParkingGarage garage = new ParkingGarage(parkingSpaces);

        for (int i = 0; i < parkingSpaces; i++){
            Car car = new Car("" + i, garage);
            car.start();
        }
    }
}

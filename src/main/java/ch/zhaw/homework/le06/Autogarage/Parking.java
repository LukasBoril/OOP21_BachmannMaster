package ch.zhaw.homework.le06.Autogarage;

public class Parking {

    public static void main(String[] args) {
        ParkingGarage garage = new ParkingGarage(5);
        Car c1 = new Car("c1",garage);
        Car c2 = new Car("c2",garage);
        Car c3 = new Car("c3",garage);
        Car c4 = new Car("c4",garage);
        Car c5 = new Car("c5",garage);
        Car c6 = new Car("c6",garage);
        Car c7 = new Car("c7",garage);
        Car c8 = new Car("c8",garage);
        Car c9 = new Car("c9",garage);
        Car c10 = new Car("c10",garage);
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
        c8.start();
        c9.start();
        c10.start();

    }





}

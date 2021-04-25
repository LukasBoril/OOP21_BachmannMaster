package ch.zhaw.homework.le06;

public class Parking {
    public static void main(String[] args) {
        ParkingGarage parkhaus = new ParkingGarage(10);
        Car car1 = new Car("Auto 1", parkhaus);
        Car car2 = new Car("Auto 2", parkhaus);
        Car car3 = new Car("Auto 3", parkhaus);
        Car car4 = new Car("Auto 4", parkhaus);
        Car car5 = new Car("Auto 5", parkhaus);
        Car car6 = new Car("Auto 6", parkhaus);
        Car car7 = new Car("Auto 7", parkhaus);
        Car car8 = new Car("Auto 8", parkhaus);
        Car car9 = new Car("Auto 9", parkhaus);
        Car car10 = new Car("Auto 10", parkhaus);

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
        car7.start();
        car8.start();
        car9.start();
        car10.start();

    }
}

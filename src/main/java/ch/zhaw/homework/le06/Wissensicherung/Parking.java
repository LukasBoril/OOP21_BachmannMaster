package ch.zhaw.homework.le06.Wissensicherung;

public class Parking {
    public static void main(String[] args) {
        ParkingGarage garage = new ParkingGarage(10);
        for (int i = 1; i <= 14; i++) {
            new Car("Auto " + i, garage);
        }
    }

}

class ParkingGarage {

    private static int places;
    private int maxplaces;

    public ParkingGarage(int maxplaces){
        this.maxplaces = maxplaces;
        this.places = 0;
    }

    synchronized public void enter(){
        if (places == maxplaces) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
            places++;
            notify();

    }

    synchronized public void leave() {
        if (places == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
            places--;
            notify();


    }

    public int getPlaces() {
        return places;
    }
}

class Car extends Thread {
    private final ParkingGarage garage;

    public Car(String name, ParkingGarage garage) {
        super(name);
        this.garage = garage;
        start();
    }

    public void run() {
        while (true) {

            try {
                sleep((int) (Math.random() * 10000));
            } catch (InterruptedException ignored) {
            }
            synchronized (garage) {
                garage.enter();
                System.out.println(getName() + ": eingefahren");
            }
            try {
                sleep((int) (Math.random() * 10000));
                System.out.println("Anzahl Auto in der Garage:" + garage.getPlaces());
            } catch (InterruptedException ignored) {
            }
            synchronized (garage) {
                garage.leave();
                System.out.println(getName() + ": ausgefahren");
            }

        }
    }
}

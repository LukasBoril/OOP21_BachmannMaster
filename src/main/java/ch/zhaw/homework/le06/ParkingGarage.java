package ch.zhaw.homework.le06;

public class ParkingGarage {
    private int maxParkSpaces;
    private static int currentOccupiedParkings;

    public ParkingGarage(int maxParkings) {
        maxParkSpaces = maxParkings;
    }

    public synchronized boolean enter() {
        if (currentOccupiedParkings < maxParkSpaces) {
            currentOccupiedParkings++;
            System.out.println(Thread.currentThread().getName() + ": eingefahren");
            return true;
        } else {
            return false;
        }

    }

    public synchronized void leave() {
         currentOccupiedParkings--;
            System.out.println(Thread.currentThread().getName() + ": ausgefahren");
    }


}


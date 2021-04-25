package ch.zhaw.homework.le06;

public class Car extends Thread{

    private ParkingGarage garage;

    public Car(String name, ParkingGarage garage)
    {

        this.setName(name);
        this.garage = garage;
    }

    public void run() {

        while (true) {
            try {
                sleep((int) (Math.random() * 10000));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            if (garage.enter()) {   // leave soll nur aufgerufen werden wenn enter successfull war
                try {
                    sleep((int) (Math.random() * 10000));
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                garage.leave();
            }

        }
    }
}
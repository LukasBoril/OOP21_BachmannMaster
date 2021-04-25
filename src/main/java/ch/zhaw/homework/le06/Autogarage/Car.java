package ch.zhaw.homework.le06.Autogarage;

public class Car extends Thread
{
    private String name;
    private ParkingGarage garage;

    public Car(String name, ParkingGarage garage)
    {
        this.name = name;
        this.garage = garage;
    }

    public String getCarName() {
        return name;
    }


    public void run() {
        while(true)
        {
            try {
                Thread.sleep((int) (Math.random()*10000));
            } catch (InterruptedException e) {
            }
            garage.enter(this);
            try {
                Thread.sleep((int) (Math.random()*10000));
            } catch (InterruptedException e) {
            }
            garage.leave(this);
        }
    }

}

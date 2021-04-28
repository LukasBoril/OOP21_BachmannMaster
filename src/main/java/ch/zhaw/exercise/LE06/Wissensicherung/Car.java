package ch.zhaw.exercise.LE06.Wissensicherung;

public class Car extends Thread{

    private int name;
    private Garage garage;

    public Car(int name, Garage garage)
    {
        this.name = name;
        this.garage = garage;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * 10000));
            } catch (InterruptedException ignored) {
            }
            garage.enter(this);

            try {
                Thread.sleep((int) (Math.random() * 10000));
            } catch (InterruptedException ignored) {
            }
            garage.leave(this);

        }
    }

    public int getNumber()
    {
        return name;
    }

}

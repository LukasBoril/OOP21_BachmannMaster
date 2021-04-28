package ch.zhaw.exercise.LE06.Wissensicherung;

public class Parking {

    public static void main(String[] args) {
        Garage g = new Garage(10);
        //Car[] cars = new Car[10];
        for (int i = 0; i < 10; i++){
            Car c = new Car(i, g);
            c.start();
        }
        /*for (Car c : cars) {
            c.run();
        }*/

    }

}

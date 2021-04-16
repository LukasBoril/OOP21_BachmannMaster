package ch.zhaw.homework.le04.task3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class DeserializeCar {
    public static void main(String[] args) {

        try (InputStream fis = new FileInputStream("src/car2.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Car car = (Car) ois.readObject();

            System.out.println("Farbe: " + car.getColor());
            System.out.println("Hubraum: " + car.getEngine().getCapacity());
            System.out.print("Nummber: " + car.getNumber());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

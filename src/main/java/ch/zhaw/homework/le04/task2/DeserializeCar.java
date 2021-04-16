package ch.zhaw.homework.le04.task2;


import ch.zhaw.homework.le04.task1.Car;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class DeserializeCar {
    public static void main(String[] args) {

        try (InputStream fis = new FileInputStream("src/car.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Car car = (Car) ois.readObject();

            System.out.println("Farbe: " + car.getColor());
            System.out.println("Hubraum: " + car.getEngine().getCapacity());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

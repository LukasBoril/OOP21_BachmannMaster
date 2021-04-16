package ch.zhaw.homework.le04.task3;


import ch.zhaw.homework.le04.task1.Engine;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerializeCar {

    public static void main(String[] args) {

        Car car = new Car("black", new Engine(3745));
        car.setNumber("AG 007");

        try (OutputStream fos = new FileOutputStream("src/car2.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(car);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

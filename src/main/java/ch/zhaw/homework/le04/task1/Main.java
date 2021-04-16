package ch.zhaw.homework.le04.task1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Main {

    public static void main(String[] args) {

        Car car = new Car("black", new Engine(3745));

        try (OutputStream fos = new FileOutputStream("src/car.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(car);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

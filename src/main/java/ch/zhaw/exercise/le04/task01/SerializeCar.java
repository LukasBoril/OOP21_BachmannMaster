package ch.zhaw.exercise.le04.task01;

import ch.zhaw.exercise.le04.task02.Car;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerializeCar {

    public static void main(String[] args) {

        Car car = new Car("Rot", 1200, "123456");

        try {
            OutputStream fos = new FileOutputStream("src/auto.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(car);
            } catch (IOException e){
            e.printStackTrace();
        }

    }
}

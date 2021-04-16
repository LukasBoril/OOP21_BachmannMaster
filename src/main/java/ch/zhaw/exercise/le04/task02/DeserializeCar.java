package ch.zhaw.exercise.le04.task02;

import ch.zhaw.exercise.le04.task01.Car;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class DeserializeCar {

    public static void main(String[] args) {

        try {
            InputStream fis = new FileInputStream("src/auto.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Car car = (Car) ois.readObject();
            ois.close();

            System.out.println(car.getColour());
            System.out.println(car.getMotorSize());
            System.out.println(car.getVehicleNumber());

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

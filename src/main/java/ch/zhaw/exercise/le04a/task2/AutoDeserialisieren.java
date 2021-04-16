package ch.zhaw.exercise.le04a.task2;

import ch.zhaw.exercise.le04a.task1.Auto;
import jdk.internal.util.xml.impl.Input;

import java.io.*;

public class AutoDeserialisieren {

    public static void main(String[] args) {
        try (InputStream fis = new FileInputStream("src/auto.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Auto auto = (Auto) ois.readObject();

            System.out.println("Farbe: " + auto.getFarbe());
            System.out.println("Hubraum: " + auto.getMotor().getHubraum());
//            System.out.println("Baujahr: " + auto.getBaujahr());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

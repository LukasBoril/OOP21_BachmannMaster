package ch.zhaw.exercise.LE04.Task2;

import ch.zhaw.exercise.LE04.Task1.Auto;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AutoDeserialisation {

    public static void main(String[] args) {

        try {
            InputStream fis = new FileInputStream("src/main/java/ch/zhaw/exercise/LE04/Task1/auto.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Auto auto = (Auto) ois.readObject();

            System.out.println("Farbe: " + auto.getFarbe());
            System.out.println("Hubraum: " + auto.getMotor().getHubraum());
        } catch (Exception e) { //konkrete Exceptions catchen besser, wenn Fehlertext an Anwender ausgeben werden soll
            // in diesem Fall "Class not Found..." und IOException mit || catchen.
            e.printStackTrace();
        }
    }
}

package ch.zhaw.exercise.LE04.Task4;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class AutoDeserialisation {

    public static void main(String[] args) {

        try {
            InputStream fis = new FileInputStream("src/main/java/ch/zhaw/exercise/LE04/Task4/auto.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Auto auto = (Auto) ois.readObject();

            System.out.println("Farbe: " + auto.getFarbe());
            System.out.println("Hubraum: " + auto.getMotor().getHubraum());
            System.out.println("Nummer: " + auto.getNummer());
        } catch (Exception e) { //konkrete Exceptions catchen besser, wenn Fehlertext an Anwender ausgeben werden soll
            // in diesem Fall "Class not Found..." und IOException mit || catchen.
            e.printStackTrace();
        }
    }
}

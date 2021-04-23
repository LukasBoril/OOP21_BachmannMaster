package ch.zhaw.exercise.le04a.task2;

import java.io.*;

public class AutoDeserialisieren {

    public static void main(String[] args) {
        try (InputStream fis = new FileInputStream("src/auto.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Auto auto = (Auto) ois.readObject();
            System.out.println("Farbe: " + auto.getFarbe());
            System.out.println("Hubraum: " + auto.getMotor().getHubraum());
        }

        catch (ClassNotFoundException | IOException e)
        {
            e.printStackTrace();
        }
    }


}

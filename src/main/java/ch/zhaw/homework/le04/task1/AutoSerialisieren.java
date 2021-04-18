package ch.zhaw.homework.le04.task1;

import ch.zhaw.exercise.le03b.task2.A;

import java.io.*;

public class AutoSerialisieren {

    public static void main(String[] args) throws IOException {

        Auto a1 = new Auto(new Motor(1000), "Orange");

        try (OutputStream fos = new FileOutputStream("src/auto.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(a1);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

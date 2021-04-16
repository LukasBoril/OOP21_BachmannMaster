package ch.zhaw.homework.le03b;

import java.io.*;

public class AutoSerialisieren {

    public static void main(String[] args) {
        //Auto a2;
        Auto a1 = new Auto(new Motor(200), "Orange");

        try (OutputStream fos = new FileOutputStream("src/auto.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                 oos.writeObject(a1);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

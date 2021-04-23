package ch.zhaw.exercise.le04a.task1;

import java.io.*;

public class AutoSerialisieren {

    public static void main(String[] args) {
        Auto a1 = new Auto("rot", new Motor(500));

        try (OutputStream fos = new FileOutputStream("src/auto.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)
        )
        {
            oos.writeObject(a1);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}

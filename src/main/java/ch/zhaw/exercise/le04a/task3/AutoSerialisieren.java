package ch.zhaw.exercise.le04a.task3;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AutoSerialisieren {

    public static void main(String[] args) {
        Auto a1 = new Auto("rot", new Motor(500));
        a1.setNummer("AG 123");

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

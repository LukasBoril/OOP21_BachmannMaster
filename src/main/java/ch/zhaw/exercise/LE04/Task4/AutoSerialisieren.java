package ch.zhaw.exercise.LE04.Task4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AutoSerialisieren {

    public static void main(String[] args) {

        Fahrzeug a1 = new Auto(new Motor(500), "Gelb");
        a1.setNummer("AR 33533");

        try {
            OutputStream fos = new FileOutputStream("src/main/java/ch/zhaw/exercise/LE04/Task4/auto.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(a1);

        } catch (IOException e){
            e.printStackTrace();
        }

    }
}

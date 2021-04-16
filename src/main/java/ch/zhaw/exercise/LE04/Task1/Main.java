package ch.zhaw.exercise.LE04.Task1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Main {

    public static void main(String[] args) {

        Auto a1 = new Auto(new Motor(500), "Gelb");

        try {
            OutputStream fos = new FileOutputStream("src/main/java/ch/zhaw/exercise/LE04/Task1/auto.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(a1);

        } catch (IOException e){
            e.printStackTrace();
        }

    }
}

package ch.zhaw.exercise.le04a.task1;

import ch.zhaw.exercise.le03b.task2.A;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AutoSerialisieren {
    public static void main(String[] args) {
        Auto a1 = new Auto(new Motor(1200), "rot");
        a1.setNummer("ZH 123");
    try(OutputStream fos = new FileOutputStream("src/auto.ser"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
        oos.writeObject(a1);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}

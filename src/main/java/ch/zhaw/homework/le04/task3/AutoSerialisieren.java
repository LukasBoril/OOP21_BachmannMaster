package ch.zhaw.homework.le04.task3;

import java.io.*;

public class AutoSerialisieren {

    public static void main(String[] args) throws IOException {

        Auto a1 = new Auto(new Motor(1000), "Orange");
        a1.setNumber("ZH 1232432"); // wenn in der Klasse Fahrzeug "Serializable" nicht implementiert

        try (OutputStream fos = new FileOutputStream("src/auto.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(a1);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

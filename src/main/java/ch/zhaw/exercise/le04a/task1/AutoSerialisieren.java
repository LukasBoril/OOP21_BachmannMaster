package ch.zhaw.exercise.le04a.task1;

import java.io.*;

public class AutoSerialisieren {
    public static void main(String[] args) {
        Auto a2;
        Auto a1 = new Auto(new Motor(200), "Orange");
        a1.setNummer("ZH 407 384");

        serialize(a1);

        a2 = unsserialize();
        System.out.println("Farbe: " + a2.getFarbe());
        System.out.println("Hubraum: " + a2.getMotor());
        System.out.println("Nummernschild: " + a2.getNummer());


        }

    public static void serialize(Auto auto) {
        try (OutputStream fos = new FileOutputStream("src/auto.ser")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(auto);
            System.out.println("Object serialisiert!");
            System.out.println("----------------------");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Auto unsserialize() {
        try (InputStream fis = new FileInputStream("src/auto.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);

            System.out.println("Object deserialisiert:");
            System.out.println("----------------------");
            return (Auto) ois.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

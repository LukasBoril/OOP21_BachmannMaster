package ch.zhaw.exercise.le04a.task1;

import java.io.*;

public class AutoSerialisieren {
    public static void main(String[] args) {
        Auto a2;
        Auto a1 = new Auto(new Motor(200), "Orange");

        serialize(a1);

        a2 = unsserialize();
        System.out.println("farbe: " + a2.getFarbe());
        System.out.println("hubraum: " + a2.getMotor());


        }

    public static void serialize(Auto auto) {
        try (OutputStream fos = new FileOutputStream("src/auto.ser")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(auto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Auto unsserialize() {
        try (InputStream fis = new FileInputStream("src/auto.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);

            return (Auto) ois.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

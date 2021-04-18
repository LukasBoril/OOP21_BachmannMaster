package ch.zhaw.homework.le04a;

import java.io.*;

public class AutoDeSerialisieren {

    public static void main(String[] args) {


        try (InputStream fis = new FileInputStream("src/auto.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {


            Auto a2 = (Auto) ois.readObject();

            System.out.println("successfully read <auto.ser> file");
            System.out.println("----------------------------------");
            System.out.println("Polizeischild: " + a2.getPschild() +"\n"
                                +"Farbe: " + a2.getFarbe() +"\nHubraum: "
                                + a2.getMotor().getHubraum());
        }
        catch( ClassNotFoundException | IOException exception) {
                exception.printStackTrace();
        }

    }
}
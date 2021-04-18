package ch.zhaw.homework.le04a;

import java.io.*;

public class AutoSerialisieren {

    public static void main(String[] args) {

        Auto a1 = new Auto(new Motor(2000), "Silber met");
        a1.setPschild("AR 777");

        try (OutputStream fos = new FileOutputStream("src/auto.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                 oos.writeObject(a1);
                System.out.println("successfully write <auto.ser> file");
                System.out.println("----------------------------------");
                System.out.println("Polizeischild: " + a1.getPschild() +"\n"
                                    +"Farbe: " + a1.getFarbe() +"\nHubraum: "
                                    + a1.getMotor().getHubraum());
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

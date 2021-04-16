package ch.zhaw.exercise.le04a.task2;

import ch.zhaw.exercise.le04a.task1.Auto;
import ch.zhaw.exercise.le04a.task1.Motor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;


public class AutoDeseralisieren {

    public static void main(String[] args) {

       try(InputStream fis = new FileInputStream("src/auto.ser"); ObjectInputStream ois = new ObjectInputStream(fis)) {
           Auto auto = (Auto) ois.readObject();
           System.out.println(auto.getFarbe() + auto.getMotor().getHubraum() + auto.getNummer());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

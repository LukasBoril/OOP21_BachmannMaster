package ch.zhaw.exercise.le04a.task3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class AutoDeserialisieren {

	public static void main(String[] args) {


		try (InputStream fis = new FileInputStream("src/auto.ser");
				ObjectInputStream ois = new ObjectInputStream(fis)){


			Auto auto = (Auto) ois.readObject();

			System.out.println("Farbe: " + auto.getFarbe());
			System.out.println("Hubraum: " + auto.getMotor().getHubraum());
		    System.out.println("Nummer: " + auto.getNummer());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
}

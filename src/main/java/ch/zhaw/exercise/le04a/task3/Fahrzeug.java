package ch.zhaw.exercise.le04a.task3;

import java.io.Serializable;

public class Fahrzeug  implements Serializable { //ohne Serializable wird Nummer nicht serialisiert

	private static final long serialVersionUID = 10000L;

	private String nummer;

	// Variante 1
	public Fahrzeug() {}

	public Fahrzeug(String nummer) {
	   this.nummer = nummer;
	}

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

}

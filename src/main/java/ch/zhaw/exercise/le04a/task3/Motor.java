package ch.zhaw.exercise.le04a.task3;

import java.io.Serializable;

public class Motor  implements Serializable {

	private static final long serialVersionUID = 1198855187409536290L;

	private int hubraum;

	public Motor(int hubraum) {
		this.hubraum = hubraum;
	}

	public int getHubraum() {
		return hubraum;
	}
}

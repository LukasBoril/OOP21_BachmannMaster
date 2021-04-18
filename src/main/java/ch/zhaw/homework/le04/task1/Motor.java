package ch.zhaw.homework.le04.task1;

import java.io.Serializable;

public class Motor implements Serializable {

    private static final long serialVersionUID = 1L;

    private int hubraum;

    public Motor(int hubraum) {
        this.hubraum = hubraum;
    }

    public int getHubraum() {
        return hubraum;
    }
}

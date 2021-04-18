package ch.zhaw.homework.le04a;

import java.io.Serializable;

public class Motor implements Serializable{
    private static final long serialVersionID = 1L;

    //private transient int hubraum;
    private int hubraum;

    public Motor(int hubraum) {
        this.hubraum = hubraum;
    }

    public int getHubraum() {
        return hubraum;
    }
}

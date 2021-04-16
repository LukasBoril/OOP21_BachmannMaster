package ch.zhaw.exercise.LE04.Task4;

import java.io.Serializable;

public class Motor implements Serializable {

    private static final long serialVersionUID = 1L;
    private int hubraum;

    public Motor (int hubraum){
        this.hubraum = hubraum;
    }

    public int getHubraum(){
        return hubraum;
    }

}

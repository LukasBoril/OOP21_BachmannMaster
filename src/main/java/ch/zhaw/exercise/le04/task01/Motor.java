package ch.zhaw.exercise.le04.task01;

import java.io.Serializable;

public class Motor implements Serializable {

    private static final long serialVersionUID = 1L;
    private int motorSize;

    public Motor(int motorSize){
        this.motorSize = motorSize;
    }

    public int getMotorSize(){
        return motorSize;
    }
}

package ch.zhaw.homework.le04.task1;

import java.io.Serializable;

public class Car implements Serializable {

    private static final long serialVersionUID = 7700425650979628675L;

    private String color;
    private Engine engine;

    public Car(String color, Engine engine) {
        this.color = color;
        this.engine = engine;

    }

    public Engine getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }
}

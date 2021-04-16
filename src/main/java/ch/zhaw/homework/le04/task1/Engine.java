package ch.zhaw.homework.le04.task1;

import java.io.Serializable;

public class Engine implements Serializable {

    private static final long serialVersionUID = -8356357592163856680L;
    private int capacity;

    public Engine(int capacity) {
        this.capacity = capacity;

    }

    public int getCapacity() {
        return capacity;
    }
}

package ch.zhaw.exercise.le07a.task01;

public class Semaphore {

    private int value;

    public Semaphore(int init){
        if (init < 0) {
            throw new IllegalArgumentException("Parameter < 0");
        }
        this.value = init;
    }

    public synchronized void p(){
        while (value == 0){
            try {
                wait();
            } catch (InterruptedException ignored) {

            }
            value--;
        }
    }

    public synchronized void v() {
        value++;
        notify();
    }
}

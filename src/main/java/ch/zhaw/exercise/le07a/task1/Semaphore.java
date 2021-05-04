package ch.zhaw.exercise.le07a.task1;

public class Semaphore {
    private int value;
    public Semaphore(int init) {
        if(init< 0) {
            throw new IllegalArgumentException("Parameter < 0");
        }
        value= init;
    }
    //probieren (eine Eintritskarte wird reduziert)
    public synchronized void p() {
        while(value== 0) {
            try{
                wait();
            } catch(InterruptedException e) {}
        }value--;

    //erhöhen (eintrittskarte wird wieder zurückgegeben, kann erhöht werden)
    }public synchronized void v() {
        value++;
        notify();
    }
}

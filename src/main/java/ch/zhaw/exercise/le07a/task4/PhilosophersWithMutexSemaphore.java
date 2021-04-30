package ch.zhaw.exercise.le07a.task4;

import ch.zhaw.exercise.le07a.task1.Semaphore;

public class PhilosophersWithMutexSemaphore implements Runnable {
    private Semaphore[] sems;
    private int number;
    private int left, right;

    public PhilosophersWithMutexSemaphore(Semaphore[] sems, int number) {
        this.sems = sems;
        this.number = number;
        left = number;
        right = number + 1;
        if (right == sems.length) {
            right = 0;
        }
    }

    public void run() {
        while (true) {
            think(number);
            sems[left].p();
            sems[right].p();
            eat(number);
            sems[left].v();
            sems[right].v();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {  }
        }
    }

    private void think(int number) {
        System.out.println("Phlosoph Nr. " + number + " denkt.");
    }

    private void eat(int number) {
        System.out.println("Phlosoph Nr. " + number + " isst.");
    }

    private static final int NUMBER = 5;

    public static void main(String[] args) {
        Semaphore[] sems = new Semaphore[NUMBER];
        for (int i = 0; i < NUMBER; i++) {
            sems[i] = new Semaphore(1);
        }
        for (int i = 0; i < NUMBER; i++) {
            new Thread(new PhilosophersWithMutexSemaphore(sems, i)).start();
        }
    }
}

package ch.zhaw.exercise.le07a.task1;

public class MutualExclusion {
    public static void main(String[] args) {
        Semaphore mutex = new Semaphore(1);
        for (int i = 1; i <= 10; i++) {
            new MutexThread(mutex);
        }
    }
}
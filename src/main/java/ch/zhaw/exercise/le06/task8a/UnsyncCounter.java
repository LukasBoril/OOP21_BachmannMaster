package ch.zhaw.exercise.le06.task8a;

public class UnsyncCounter {
    public static void main(String... args) {
        Counter counter = new Counter();
        for (int i = 0; i < 10; i++)
            new Worker(counter).start();
        System.out.println("Exit Main");
    }
}

class Counter {

    private int count = 0;
    public final static int LIMIT = 5;

    void up(String threadName) {
        if (count < LIMIT)
            count++;

        if (count > LIMIT)
            System.out.println(threadName + " counter overflow: " + count);
    }

    void down(String threadName) {
        if (count > 0)
            count--;
        if (count < 0)
            System.out.println(threadName + " counter underrun: " + count);
    }
}

class Worker extends Thread {
    Counter counter;

    Worker(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        System.out.println("Thread " + this.getName() + " started!");

        while (true) {

            for (int i = 0; i < Counter.LIMIT; i++)
                counter.up(this.getName());
            for (int i = 0; i < Counter.LIMIT; i++)
                counter.down(this.getName());
        }
    }
}


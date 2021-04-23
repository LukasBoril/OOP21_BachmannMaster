package ch.zhaw.exercise.LE06.Task8b;

public class SynchObjectCounter {
    public static void main(String... args) {
        Counter counter = new Counter();
        for (int i = 0; i < 10; i++)
            new Worker(counter).start();
    }
}

class Counter {

    private int count = 0;
    public final static int LIMIT = 5;
    private final Object obj = new Object();

    void up(String threadName) {
        synchronized (obj) {
            if (count < LIMIT)
                count++;
        }

        if (count > LIMIT)
            System.out.println(threadName + " counter overflow: " + count);
    }

    void down(String threadName) {
        synchronized (obj) {
            if (count > 0)
                count--;
        }
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

package ch.zhaw.exercise.le06.task9;

public class ProducerConsumer {

    public static void main (String[] args) {
        Buffer buffer = new Buffer();
        new Producer(buffer, 1000).start();
        new Consumer(buffer).start();
        new Producer(buffer, 2000).start();
        new Consumer(buffer).start();
        new Producer(buffer, 3000).start();
        new Consumer(buffer).start();
    }
}


class Producer extends Thread {
    Buffer buffer;
    int startValue;

    Producer (Buffer buffer, int startValue) {
        this.buffer = buffer;
        this.startValue = startValue;
    }

    public void run() {
        for (int x = startValue; x < 100 + startValue; x++) {
            buffer.put(x);
            System.out.println("put " + Thread.currentThread().getName() + " " + x);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    Buffer buffer;
    Consumer (Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            System.out.println("get " + Thread.currentThread().getName() + " - " + buffer.get());
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Buffer {
    private boolean available = false;
    private int data;

    public synchronized void put(int x) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        data = x;
        available = true;
        notifyAll();
    }

    public synchronized int get() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        available = false;
        notifyAll();
        return data;
    }
}

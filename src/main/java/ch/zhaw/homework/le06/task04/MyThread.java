package ch.zhaw.homework.le06.task04;

public class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            String name = Thread.currentThread().getName();
            System.out.println("Thread " + name + " hat Nummer " + i + " verarbeitet");
        }
    }
}

class ThreadNaming {

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());
        t1.setName("Eins");
        t2.setName("Zwei");
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName());

        // alles in einer Zeile
        new Thread(new MyThread(), "Drei").start();

    }
}

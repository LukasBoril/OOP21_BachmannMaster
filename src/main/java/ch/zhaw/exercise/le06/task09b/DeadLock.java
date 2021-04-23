package ch.zhaw.exercise.le06.task09b;

public class DeadLock {
    public static void main(String[] args) {
        final Object resource1 = new Object();
        final Object resource2 = new Object();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                // Lock resource 1
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + ": locked resource 1");
                    //          try
                    //          {
                    //            Thread.sleep(50);
                    //          } catch (InterruptedException e) {
                    //          }
                    System.out.println(Thread.currentThread().getName() + ": is waiting for resource 2");
                    synchronized (resource2) {
                        System.out.println(Thread.currentThread().getName() + ": locked resource 2");
                    }
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override public void run() {
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + ": locked resource 2");
                    //          try {
                    //            Thread.sleep(50);
                    //          } catch (InterruptedException e) {
                    //          }
                    System.out.println(Thread.currentThread().getName() + ": is waiting for resource 1");
                    synchronized (resource1) {
                        System.out.println(Thread.currentThread().getName() + ": locked resource 1");
                    }
                }
            }
        };
        // t1 tries to lock resource1 then resource2
        Thread t1 = new Thread(r1);
        // t2 tries to lock resource2 then resource1
        Thread t2 = new Thread(r2);
        // If all goes as planned, deadlock will occur,
        // and the program will never exit.
        t1.start();
        t2.start();
    }
}
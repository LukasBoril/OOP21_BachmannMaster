package ch.zhaw.exercise.le06.task1;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class TwoThreadsTest {

    public static void main(String[] args) {
        new SimpleThread("Jamaica").start();
        new SimpleThread("Fiji").start();
        System.out.println("main exits " + Thread.currentThread().toString());
    }
}

class SimpleThread extends Thread {

    public SimpleThread(String str) {
        super(str);
    }

    public void run() {

        for (int i = 0; i < 10; i++) {
            long aktuelleZeit = System.currentTimeMillis();
            long millis = aktuelleZeit % 1000;
            long second = (aktuelleZeit / 1000) % 60;
            long minute = (aktuelleZeit / (1000 * 60)) % 60;
            long hour = (aktuelleZeit / (1000 * 60 * 60)) % 24;
            String time = String.format("%02d:%02d:%02d.%d", hour, minute, second, millis);
            System.out.println(time + ";" + i + " " + getName());

            try {
                //Thread.sleep((int) (Math.random() * 1000));
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {

            }
        }
        System.out.println("DONE! " + getName());
    }
}


package ch.zhaw.exercise.le06.task2;

public class TwoThredsTestR {

        public static void main(String[] args) {
            MySimpleRun aRunnable = new MySimpleRun();
            new Thread(aRunnable,"Jamaica").start();
            new Thread(aRunnable,"Fiji").start();
            System.out.println("main exits " + Thread.currentThread().toString());
        }

    }

    class MySimpleRun implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                long aktuelleZeit = System.currentTimeMillis();
                long millis = aktuelleZeit % 1000;
                long second = (aktuelleZeit / 1000) % 60;
                long minute = (aktuelleZeit / (1000 * 60)) % 60;
                long hour = (aktuelleZeit / (1000 * 60 * 60)) % 24;
                String time = String.format("%02d:%02d:%02d.%d", hour, minute, second, millis);
                System.out.println(time + ": " + i + " " + Thread.currentThread().getName());
                Thread.yield();
            }
            System.out.println("DONE! " + Thread.currentThread().getName());
        }
    }


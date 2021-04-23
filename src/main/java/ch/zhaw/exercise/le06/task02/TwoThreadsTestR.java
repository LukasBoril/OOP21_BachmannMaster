package ch.zhaw.exercise.le06.task02;

public class TwoThreadsTestR {

    public static void main(String[] args) {
        MySimpleRun aRunnable = new MySimpleRun();
        new Thread(aRunnable, "Jamaica").start();
        new Thread(aRunnable, "Fiji").start();
        System.out.println("main exits " + Thread.currentThread());
    }
}

class MySimpleRun implements Runnable{
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println(i + " " + Thread.currentThread().getName());
            Thread.yield();
        }
        System.out.println("DONE! " + Thread.currentThread().getName());
    }
}
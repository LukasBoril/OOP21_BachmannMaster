package ch.zhaw.exercise.le06.task07;

public class TwoThreadsTestR {

    public static void main(String[] args) {
        MySimpleRun aRunnable = new MySimpleRun();
        Thread t1 = new Thread(aRunnable, "Jamaica");
        Thread t2 = new Thread(aRunnable, "Fiji");
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();
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
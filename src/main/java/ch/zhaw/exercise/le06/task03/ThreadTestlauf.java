package ch.zhaw.exercise.le06.task03;

class MyRunnable implements Runnable{

    @Override
    public void run(){
        go();
    }

    private void go(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doMore();
    }

    private void doMore() {
        System.out.println("Oben auf Stack");
    }
}

public class ThreadTestlauf {
    public static void main(String[] args) {
        Runnable threadJob = new MyRunnable();
        Thread myThread = new Thread(threadJob);
        myThread.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("zurück in main");
    }
}
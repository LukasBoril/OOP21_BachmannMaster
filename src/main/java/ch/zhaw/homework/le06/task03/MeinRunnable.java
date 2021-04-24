package ch.zhaw.homework.le06.task03;

public class MeinRunnable implements Runnable{

    @Override
    public void run() {
        los();
    }

    private void los() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tuNochMehr();
    }

    private void tuNochMehr() {
        System.out.println("Oben auf den Stack");
    }
}

class ThreadTestLauf {

    public static void main(String[] args) {
        Runnable threadJob = new MeinRunnable();
        Thread meinThread = new Thread(threadJob);
        meinThread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("zurück in main");
    }
}

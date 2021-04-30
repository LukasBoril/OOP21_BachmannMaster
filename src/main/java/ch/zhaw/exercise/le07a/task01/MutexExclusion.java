package ch.zhaw.exercise.le07a.task01;

class MutexThread extends Thread{
    private Semaphore mutex;

    public MutexThread(Semaphore mutex){
        this.mutex = mutex;
        start();
    }

    @Override
    public void run() {
        while (true) {
            mutex.p();
            System.out.println("kritischen Abschnitt betreten in " + Thread.currentThread().getName());
            try {
                sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("kritischer Abschnitt in " + Thread.currentThread().getName()+ " wird verlassen");
            mutex.v();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MutexExclusion {

    public static void main(String[] args) {
        Semaphore mutex = new Semaphore(1);
        for (int i = 1; i <= 10; i++) {
            new MutexThread(mutex);
        }
    }
}

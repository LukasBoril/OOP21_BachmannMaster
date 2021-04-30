package ch.zhaw.exercise.le07a.task1;

class MutexThread extends Thread {
    private final Semaphore mutex;
    public MutexThread(Semaphore mutex) {
        this.mutex = mutex;
        start();
    }
    public void run() {
        while (true) {
            mutex.p();
            System.out.println("kritischen Abschnitt betreten");
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
            System.out.println("kritischer Abschnitt wird " +"verlassen");
            mutex.v();
            try {
                sleep( 20);
            } catch (InterruptedException e) {

            }
        }
    }
}
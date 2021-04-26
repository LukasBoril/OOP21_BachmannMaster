package ch.zhaw.exercise.le06.task6b;

public class StopThreadByInterrupt extends Thread {

    public StopThreadByInterrupt() {
        start();
    }

    public void run() {
        int i = 0;try {
            while (!isInterrupted()) {
                i++;
                System.out.println("Hallo Welt (" + i + ")");
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException: " + e.getMessage());
        }System.out.println("thread terminating ...");
    }

    public static void main(String[] args) {
        StopThreadByInterrupt st = new StopThreadByInterrupt();
        try {
            Thread.sleep(910);
        } catch (InterruptedException ignored) {
        }
        st.interrupt();
        try {
            st.join(); //warten bis alle ihre arbeit erledigt haben (warten bis er sich verbindet)
        } catch (InterruptedException ignored) {
        }System.out.println("main terminating");
    }
}

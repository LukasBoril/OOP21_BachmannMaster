package ch.zhaw.exercise.le06.task06b;

public class StopThreadByInterrupt extends Thread{

    public StopThreadByInterrupt(){
        start();
    }

    public void run(){
        int i = 0;
        try {
            while (!isInterrupted()){
                i++;
                System.out.println("Hallo Welt " + "( " + i + " )");
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException: " + e.getMessage());
        }
        System.out.println("Thread terminating...");
    }

    public static void main(String[] args) {
        StopThreadByInterrupt st = new StopThreadByInterrupt();
        try {
            Thread.sleep(910);
        } catch (InterruptedException ignored) {
        }
        st.interrupt();
        try {
            st.join();
        } catch (InterruptedException e) {
            System.out.println("main terminating");
        }
    }
}

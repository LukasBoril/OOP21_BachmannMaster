package ch.zhaw.exercise.le06.task07;

public class TwoThreadsTest {
    public static void main(String[] args) {
        new SimpleThread("Jamaica").start();
        new SimpleThread("Fiji").start();
        System.out.println("main exits " + Thread.currentThread());
    }
}

class SimpleThread extends Thread{
    public SimpleThread(String str){
        super(str);
        setDaemon(true);
    }

    public void run(){
        for(int i=0; i<10; i++){
            System.out.println(i + " " + getName());
            try {
                Thread.sleep((int) (Math.random() + 1000));
            } catch (InterruptedException ignored) {
            }
        }
        System.out.println("DONE! " + getName());
    }

}
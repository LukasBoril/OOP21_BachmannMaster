package ch.zhaw.homework.le06.task09a;

public class BlockingStack {
    private final int[] array = new int[2];
    private volatile int cnt = 0;

    synchronized public void push(int elm) throws InterruptedException {
        while (cnt == array.length) {
            wait();
        }
        array[cnt++] = elm;
        notifyAll();
    }

    synchronized public int pop() throws InterruptedException {
        while (cnt == 0) {
            wait();
        }
        notifyAll();
        return (array[--cnt]);
    }
}

class BlockingStackTest {
    public static void main (String[] args) throws InterruptedException {
        BlockingStack blockingStack = new BlockingStack();

        Runnable pushRunner = () -> {

            try {
                blockingStack.push(1);
                blockingStack.push(2);
                System.out.println("vor blocking");
                blockingStack.push(3);
                System.out.println("blocking stack aus wait");

            } catch (InterruptedException e) {

            }
        };

        new Thread(pushRunner).start();

        Thread.sleep(1000);
        blockingStack.pop();


        System.out.println("main exits"
                +Thread.currentThread().toString());
    }
}

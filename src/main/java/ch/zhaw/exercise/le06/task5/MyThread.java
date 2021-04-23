package ch.zhaw.exercise.le06.task5;

public class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            String name = Thread.currentThread().getName();
            System.out.println("Thread " + name + " hat Nummer " + i + " verarbeitet");
        }
    }
}

class ThreadLambda {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Lambda 1 ");
            for (int i = 0; i < 5; i++) {
                String name = Thread.currentThread().getName();
                System.out.println("Thread " + name + " hat Nummer " + i + " verarbeitet");
            }

        }, "Lambda 1").start();


        Runnable blabla = () -> {
            System.out.println("Lambda 2 -blabla");
            for (int i = 0; i < 5; i++) {
                String name = Thread.currentThread().getName();
                System.out.println("Thread " + name + " hat Nummer " + i + " verarbeitet");
            }
        };

        new Thread(blabla, "Lambda 2 -blabla").start();

        // alles in einer Zeile

        new Thread(new MyThread(), "Thread in einer Zeile").start();

        // Instanz Runnable
        Runnable runner = () -> System.out.println("Hallo " +
                Thread.currentThread().getName());
        new Thread(runner, "Welt 1").start();
        new Thread(runner, "Welt 2").start();
    }
}


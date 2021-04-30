package ch.zhaw.exercise.le07a.task02;


import ch.zhaw.exercise.le07a.task01.Semaphore;

class T1 extends Thread {
    private Semaphore[] semaphores;

    public T1(Semaphore[] semaphores, String name) {
        super(name);
        this.semaphores = semaphores;
        start();
    }

    private void a1() {
        System.out.println("a1");
    }

    @Override
    public void run() {
        a1();
        semaphores[0].v();
        semaphores[1].v();
        semaphores[2].v();
    }
}

class T2 extends Thread {
    private Semaphore[] semaphores;

    public T2(Semaphore[] semaphores, String name) {
        super(name);
        this.semaphores = semaphores;
        start();
    }

    private void a2() {
        System.out.println("a2");
    }

    @Override
    public void run() {
        semaphores[0].v();
        a2();
        semaphores[3].v();
    }
}

class T3 extends Thread {
    private Semaphore[] semaphores;

    public T3(Semaphore[] semaphores, String name) {
        super(name);
        this.semaphores = semaphores;
        start();
    }

    private void a3() {
        System.out.println("a3");
    }

    @Override
    public void run() {
        semaphores[1].p();
        a3();
        semaphores[4].v();
    }
}

class T4 extends Thread {
    private Semaphore[] semaphores;

    public T4(Semaphore[] semaphores, String name) {
        super(name);
        this.semaphores = semaphores;
        start();
    }

    private void a4() {
        System.out.println("a4");
    }

    @Override
    public void run() {
        semaphores[2].p();
        a4();
        semaphores[5].v();
    }
}

class T5 extends Thread {
    private Semaphore[] semaphores;

    public T5(Semaphore[] semaphores, String name) {
        super(name);
        this.semaphores = semaphores;
        start();
    }

    private void a5() {
        System.out.println("a5");
    }

    @Override
    public void run() {
        semaphores[3].p();
        semaphores[4].p();
        semaphores[5].p();
        a5();
    }
}

public class TimingRelation {
    public static void main(String[] args) {
        Semaphore[] semaphores = new Semaphore[6];
        for (int i=0; i< semaphores.length; i++) {
            semaphores[i] = new Semaphore(0);
        }
        new T1(semaphores, "T1");
        new T2(semaphores, "T2");
        new T3(semaphores, "T3");
        new T4(semaphores, "T4");
        new T5(semaphores, "T5");
    }
}

package ch.zhaw.exercise.le07a.task2;

import ch.zhaw.exercise.le07a.task1.Semaphore;

class T1 extends Thread {
    private Semaphore[] sems;

    public T1(Semaphore[] sems, String name) {
        super(name);
        this.sems = sems;
        start();
    }

    public void run() {
        a1();
        sems[0].v();
        sems[1].v();
        sems[2].v();
    }

    private void a1() {
        System.out.println("a1");
    }

}

class T2 extends Thread {
    private Semaphore[] sems;

    public T2(Semaphore[] sems, String name) {
        super(name);
        this.sems = sems;
        start();
    }

    public void run() {
        sems[0].p();
        a2();
        sems[3].v();
    }

    private void a2() {
        System.out.println("a2");
    }
}

class T3 extends Thread {
    private Semaphore[] sems;

    public T3(Semaphore[] sems, String name) {
        super(name);
        this.sems = sems;
        start();
    }

    public void run() {
        sems[1].p();
        a3();
        sems[4].v();
    }

    private void a3() {
        System.out.println("a3");
    }
}

class T4 extends Thread {
    private Semaphore[] sems;

    public T4(Semaphore[] sems, String name) {
        super(name);
        this.sems = sems;
        start();
    }

    public void run() {
        sems[2].p();
        a4();
        sems[5].v();
    }

    private void a4() {
        System.out.println("a4");
    }
}

class T5 extends Thread {
    private Semaphore[] sems;

    public T5(Semaphore[] sems, String name) {
        super(name);
        this.sems = sems;
        start();
    }

    public void run() {
        sems[3].v();
        sems[4].v();
        sems[5].v();
        a5();
    }

    private void a5() {
        System.out.println("a5");
    }
}


public class TimingRelation {
    public static void main(String[] args) {
        Semaphore[] sems= new Semaphore[6];
        for(int i= 0; i< sems.length; i++) {
            sems[i] = new Semaphore(0);
        }
        new T1(sems, "T1");
        new T2(sems, "T2");
        new T3(sems, "T3");
        new T4(sems, "T4");
        new T5(sems, "T5");
    }
}

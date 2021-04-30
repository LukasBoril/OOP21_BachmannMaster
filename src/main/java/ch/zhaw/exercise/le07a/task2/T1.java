package ch.zhaw.exercise.le07a.task2;

class T1 extends Thread {
    private Semaphore[] sems;
    public T1(Semaphore[] sems, String name) {
        super(name);
        this.sems = sems;
        start();
    }
    private void a1() {
        System.out.println("a1");
    }
    public void run() {
        sems[0].v();
        a1();
        sems[3].v();
    }
}
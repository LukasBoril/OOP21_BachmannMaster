package ch.zhaw.exercise.le07a.task2;

class T5 extends Thread {
    private Semaphore[] sems;
    public T5(Semaphore[] sems, String name) {
        super(name);
        this.sems = sems;
        start();
    }
    private void a5() {
        System.out.println("a5");
    }
    public void run() {
        sems[0].v();
        a5();
        sems[1].v();
// sems[2].v();
    }
}
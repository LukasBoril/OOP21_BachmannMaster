package ch.zhaw.exercise.le07a.task2;

class T2 extends Thread {
    private Semaphore[] sems;
    public T2(Semaphore[] sems, String name) {
        super(name);
        this.sems = sems;
        start();
    }
    private void a2() {
        System.out.println("a2");
    }
    public void run() {
        a2();
// sems[0].v();
 sems[1].v();
 sems[2].v();
    }
}
package ch.zhaw.exercise.le07a.task2;

class T3 extends Thread {
    private Semaphore[] sems;
    public T3(Semaphore[] sems, String name) {
        super(name);
        this.sems = sems;
        start();
    }
    private void a3() {
        System.out.println("a3");
    }
    public void run() {
        a3();
 sems[0].v();
 sems[1].v();
// sems[2].v();
    }
}
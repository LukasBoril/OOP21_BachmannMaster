package ch.zhaw.exercise.LE06.Task3;

class MeinRunnable implements Runnable {
    @Override
    public void run() {
        los();
    }
    private void los() { try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace(); }
        tuNochMehr();
    }
    private void tuNochMehr() { System.out.println("Oben auf den Stack");
    } }


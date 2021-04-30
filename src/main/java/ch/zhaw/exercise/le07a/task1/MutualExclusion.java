package ch.zhaw.exercise.le07a.task1;

class MutexThread extends Thread {
	private Semaphore mutex;

	public MutexThread(Semaphore mutex) {
		this.mutex = mutex;
		start();
	}

	public void run() {
		while (true) {
			// can we get a ticket? ... blocking call
			mutex.p();
			System.out.println("kritischen Abschnitt betreten: " + Thread.currentThread().getName());
			try {
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException ignored) { }
			System.out.println("kritischer Abschnitt wird " + "verlassen: " + Thread.currentThread().getName());
			// release the ticket
			mutex.v();
			try {
				Thread.sleep(20);
			} catch (InterruptedException ignored) {}
		}
	}
}

public class MutualExclusion {

	public static void main(String[] args) {
		// Semaphore with one ticket
		Semaphore mutex = new Semaphore(1);
		// one semaphore is assigned to 10 threads
		for (int i = 1; i <= 10; i++) {
			new MutexThread(mutex);
		}
	}
}

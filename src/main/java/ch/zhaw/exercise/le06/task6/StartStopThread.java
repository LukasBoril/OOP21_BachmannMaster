package ch.zhaw.exercise.le06.task6;

public class StartStopThread {

	public static void main(String[] args) {
		StopThread st = new StopThread();

		try {
			Thread.sleep(1);
		} catch (InterruptedException ignored) {
		}

		System.out.println("Main task sleep over");
		st.stopThread();
		System.out.println("Main task ends now");
	}

}

//Stopping von Threads mittels Polling
class StopThread extends Thread {
	private boolean stopped = false;

	public StopThread() {
		start();
	}

	public synchronized void stopThread() {
		stopped = true;
	}

	public synchronized boolean isStopped() {
		return stopped;
	}

	public void run() {
		int i = 0;
		while (!isStopped()) {
			i++;
			System.out.println("Hallo Welt (" + i + ")");
		}
		System.out.println("Thread endet jetzt ...");
	}

}

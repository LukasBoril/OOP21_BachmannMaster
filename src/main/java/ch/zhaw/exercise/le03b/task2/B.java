package ch.zhaw.exercise.le03b.task2;

public class B {
	public B(int x) throws Exc1, Exc2 {

		try {
			new C(x);

		} catch(Exc3 e) {
			System.out.println("B");

		} finally {
			System.out.println("finB");
		}
	}
}

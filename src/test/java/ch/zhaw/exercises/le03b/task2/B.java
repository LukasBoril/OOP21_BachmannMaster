package ch.zhaw.exercises.le03b.task2;

public class B {
	public B(int x) throws ch.zhaw.exercises.le03b.task2.Exc1, ch.zhaw.exercises.le03b.task2.Exc2 {

		try {
			new ch.zhaw.exercises.le03b.task2.C(x);

		} catch(ch.zhaw.exercises.le03b.task2.Exc3 e) {
			System.out.println("B");

		} finally {
			System.out.println("finB");
		}
	}
}

package ch.zhaw.exercises.le03b.task2;

public class A {

	public A(int x) throws ch.zhaw.exercises.le03b.task2.Exc1 {

		try {
			new B(x);

		}
		catch(ch.zhaw.exercises.le03b.task2.Exc2 e) {
			System.out.println("A");

		} finally {
			System.out.println("finA");
		}
	}
}

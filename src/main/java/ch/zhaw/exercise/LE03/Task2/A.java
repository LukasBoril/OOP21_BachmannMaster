package ch.zhaw.exercise.LE03.Task2;

public class A {

	public A(int x) throws Exc1 {

		try {
			new B(x);

		}
		catch(Exc2 e) {
			System.out.println("A");

		} finally {
			System.out.println("finA");
		}
	}
}

package ch.zhaw.exercises.le03b.task2;

public class Main {

	public static void main(String[] args) throws ch.zhaw.exercises.le03b.task2.Exc1 {
		new Main();

	}


	public Main() throws ch.zhaw.exercises.le03b.task2.Exc1 {
		try{
			int x=1;
			new A(x);
		} catch (ch.zhaw.exercises.le03b.task2.Exc1 e){
			System.out.print("Main\n");
			e.printStackTrace();
		}
	}

}

package ch.zhaw.exercise.LE03.Task2;

public class Main {

	public static void main(String[] args) throws Exc1 {
		new Main();

	}


	public Main() throws Exc1 {
		try{
			int x=1;
			new A(x);
		} catch (Exc1 e){
			System.out.print("Main\n");
			e.printStackTrace();
		}
	}

}

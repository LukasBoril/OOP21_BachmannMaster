package ch.zhaw.exercise.le03b.task3;

public class Main {

	public static void main (String[] args) {
		Telefonbuch telefonBuch = new Telefonbuch();
		try {
			telefonBuch.addEntry("Felix", "Muster");
			telefonBuch.addEntry("Felix1", "Muster");
			telefonBuch.printTelBuch();
		} catch (NotValidEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

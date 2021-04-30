package ch.zhaw.example.le03b.telefonbuch;
// import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
// import java.util.Map.Entry;

public class Telefonbuch {

	private Map<String, String> telBuch;

	public Telefonbuch() {
		this.telBuch = new TreeMap<String, String>();
	}

	public void addEntry(String name, String nummer) throws NotValidEntryException {

		if (name == null || nummer == null || name.isEmpty() || nummer.isEmpty()) {
			throw new NotValidEntryException("ein parameter ist null oder leer");
		}

		this.telBuch.put(name, nummer);
	}

	public void printTelBuch() {

		/*
		 * for-each-loop ueber set mit key und value
		 */
		for (String key : telBuch.keySet()) {
		     System.out.println(key + " " + telBuch.get(key));
		}

		/*
		 * for-each-loop ueber set mit Entry-Interface
		 */
		//    for (Entry<String, String> entry : telBuch.entrySet()) {
		//      System.out.println(entry.getKey() + " "
		//          + entry.getValue());
		//    }

		/*
		 * while-loop ueber set mit Entry-Interface
		 */
//		Iterator<Entry<String, String>> iter;
//		iter = telBuch.entrySet().iterator();
//		while(iter.hasNext()) {
//			Entry<String, String> e = iter.next();
//			System.out.println(e.getKey() + " " + e.getValue());
//		}

	}

	public String getNumber(String name) {
		return telBuch.get(name);
	}

	public static void main(String[] args) throws NotValidEntryException {
		Telefonbuch t = new Telefonbuch();
		//try {
			t.addEntry("Zora", "123123");
			t.addEntry("Alfons", "987987");
			t.addEntry("Bla", null);
		//} catch (NotValidEntryException e) {
		//	e.printStackTrace();
		//}
		t.printTelBuch();
	}
}

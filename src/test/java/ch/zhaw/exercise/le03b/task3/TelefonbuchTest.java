package ch.zhaw.exercise.le03b.task3;

import ch.zhaw.exercise.le03b.task3.NotValidEntryException;
import ch.zhaw.exercise.le03b.task3.Telefonbuch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TelefonbuchTest {

	private Telefonbuch t;

	@Before
	public void setUp() throws Exception {
		t = new Telefonbuch();
	}

	@Test
	public void testAddEntry() {

		try {
			t.addEntry("Zora", "123123");
			t.addEntry("Alfons", "987987");
			t.addEntry("", "23423");
		} catch (NotValidEntryException e) {
			System.out.println("Exception aufgetreten");
			assertEquals("ein parameter ist null oder leer",
					e.getMessage());
		}

		//assertEquals("987987", t.getNumber("Alfons"));
		//assertEquals("123123", t.getNumber("Zora"));

	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

}

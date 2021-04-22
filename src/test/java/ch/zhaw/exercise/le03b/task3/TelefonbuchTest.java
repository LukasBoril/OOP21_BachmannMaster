package ch.zhaw.exercise.le03b.task3;

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
	public void testAddEntryAllGood() {
		try {
			t.addEntry("Zora", "123123");
			t.addEntry("Alfons", "987987");
		} catch (NotValidEntryException e) {
			System.out.println("Exception aufgetreten: noValidEntry");
			assertEquals("ein Parameter ist null oder leer!",
					e.getMessage());
		} catch (NotValidPhoneNumber e) {
			System.out.println("Exception aufgetreten: noValidNumber");
			assertEquals(null,
					e.getMessage());
		}
		assertEquals("987987", t.getNumber("Alfons"));
		assertEquals("123123", t.getNumber("Zora"));

	}

	@Test
	public void testAddEntryNoValidEntry() {

		try {
			t.addEntry("", "23423");
		} catch (NotValidEntryException e) {
			System.out.println("Exception aufgetreten: noValidEntry");
			assertEquals("ein Parameter ist null oder leer!",
					e.getMessage());
        } catch (NotValidPhoneNumber e) {
            ;
		}
	}

	@Test
	public void testAddEntryNoValidNumber() {
		try {
			t.addEntry("Hans", "555");
		} catch (NotValidEntryException e) {
			;
		} catch (NotValidPhoneNumber e) {
			System.out.println("Exception aufgetreten: noValidNumber");
			assertEquals(null,
					e.getMessage());
		}
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

}

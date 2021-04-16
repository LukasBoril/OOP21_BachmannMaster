package ch.zhaw.exercise.le03a.junit5.x;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EuroTest {
	private static final Logger LOG = LogManager.getLogger(EuroTest.class);

	private Euro two;

	@BeforeEach
	public  void setUp() throws Exception {
		two = new Euro(2.0);
	}

	@Test
	public void testAdding() throws Exception {
		two.add(two);
		assertEquals(new Euro(4.0).getAmount(), two.getAmount(), 0.01);
		LOG.debug("Unit Test of testAdding successfull {}", two.getAmount());
	}

	@Test
	public void testInvalid() throws Exception {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			two.add(new Euro(-2.0));
		});

	}
}

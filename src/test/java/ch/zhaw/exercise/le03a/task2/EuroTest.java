package ch.zhaw.exercise.le03a.task2;

import junit.framework.TestCase;

public class EuroTest extends TestCase {
    private Euro two;

    protected void setUp() throws Exception {
        two = new Euro(2.0);
    }

    public void testAdding() throws Exception {
        two.add(two);
        assertEquals(new Euro(4.0).getAmount(),
                two.getAmount()
        );
    }
}

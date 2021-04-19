package ch.zhaw.exercise.le03a.task4;

import junit.framework.TestCase;

public class EuroTest extends TestCase {
    private Euro two;

    protected void setUp() throws Exception {
        two = new Euro(2.0);
    }

    public void testAdding() throws Exception {
        two.add(two);
        assertEquals(new Euro(4.0).getAmount(), two.getAmount());
    }

    public void testInvalid() throws Exception {
        try {
            two.add(new Euro(-2.0));
            fail("IllegalArgumentException expected!");
        }
        catch (IllegalArgumentException ex) {
            System.out.println("set Exception. Fullfilled");
        }
    }
}
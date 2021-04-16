package ch.zhaw.homework.le03.task2;

import ch.zhaw.example.junit.junit3.x.Euro;
import junit.framework.TestCase;

public class EuroTest extends TestCase {
    private ch.zhaw.example.junit.junit3.x.Euro two;

    protected void setUp() throws Exception {
        two = new ch.zhaw.example.junit.junit3.x.Euro(2.0);
    }
    public void testAdding() throws Exception {
        two.add(two);
        assertEquals(new ch.zhaw.example.junit.junit3.x.Euro(4.0).getAmount(),
                two.getAmount()
        );
    }

    public void testInvalid() throws Exception {
        try {
            two.add(new Euro(-2.0));
            fail("IllegalArgumentException expected!");
        }
        catch (IllegalArgumentException ex) {
        }
    }

}

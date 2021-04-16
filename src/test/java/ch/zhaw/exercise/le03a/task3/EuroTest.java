package ch.zhaw.exercise.le03a.task3;

import ch.zhaw.exercise.le03a.task2.Euro;
import junit.framework.TestCase;

public class EuroTest extends TestCase {
    private ch.zhaw.exercise.le03a.task2.Euro two;

    protected void setUp() throws Exception {
        two = new ch.zhaw.exercise.le03a.task2.Euro(2.0);
    }

    public void testAdding() throws Exception {
        two.add(two);
        assertEquals(new ch.zhaw.exercise.le03a.task2.Euro(4.0).getAmount(),
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

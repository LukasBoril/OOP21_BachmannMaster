package ch.zhaw.example.junit.junit4.x;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EuroTest {

    private Euro two;
    @Before
    public void setUp() throws Exception {
        two = new Euro(2.0);
    }
    @Test
    public void testAdding() throws Exception {
        two.add(two);
        assertEquals(new Euro(4.0).getAmount(), two.getAmount(), 0.01);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalid() throws Exception {
        two.add(new Euro(-2.0));
    }
}
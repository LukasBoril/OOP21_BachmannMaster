package ch.zhaw.exercises.le03a.task2;


import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.logging.LogManager;
import java.util.logging.Logger;

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

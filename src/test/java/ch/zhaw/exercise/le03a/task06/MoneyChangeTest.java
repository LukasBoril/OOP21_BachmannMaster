package ch.zhaw.exercise.le03a.task06;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MoneyChangeTest {

    MoneyChange moneyChange;

    @Before
    public void setUp(){
        ChangeRate changeRate = mock(ChangeRate.class);
        when(changeRate.getRate_EUROtoDOLLAR()).thenReturn(1.29);
        when(changeRate.getRate_EUROtoSFR()).thenReturn(1.25);
        when(changeRate.getRate_EUROtoEURO()).thenReturn(1.0);
        when(changeRate.getRate_EUROtoPOUND()).thenReturn(0.86);
        moneyChange = new MoneyChange(changeRate);
    }

    @Test
    public void testChange(){
        double euro = 1;
        assertEquals(1.29, moneyChange.changeMoneyToDollar(euro), 0.01);
        assertEquals(1.0, moneyChange.changeMoneyToEuro(euro), 0.01);
        assertEquals(0.86, moneyChange.changeMoneyToPound(euro), 0.01);
        assertEquals(1.25, moneyChange.changeMoneyToSFR(euro), 0.01);
    }
}

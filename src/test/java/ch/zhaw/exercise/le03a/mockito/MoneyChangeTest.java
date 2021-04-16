package ch.zhaw.exercise.le03a.mockito;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MoneyChangeTest {

	MoneyChange mc;

	@Before
	public void setUp() {
		//Mockito erzeugen
		ChangeRate cR = mock(ChangeRate.class);

		//Mockito Rückgaben bestimmen
		when(cR.getRate_EUROtoDOLLAR()).thenReturn(1.29);
		when(cR.getRate_EUROtoSFR()).thenReturn(1.25);
		when(cR.getRate_EUROtoEURO()).thenReturn(1.0);
		when(cR.getRate_EUROtoPOUND()).thenReturn(0.86);

		//Mockito einsetzen
		mc = new MoneyChange(cR);
	}

	@Test
	public void testChange() {
		//wechseln
		double euro = 1;
		assertEquals(1.29, mc.changeMoneyToDollar(euro),0.01);
		assertEquals(1.0,  mc.changeMoneyToEuro(euro),0.01);
		assertEquals(0.86, mc.changeMoneyToPound(euro),0.01);
		assertEquals(1.25, mc.changeMoneyToSFR(euro),0.01);
	}

	@Test
	public void testChange10() {
		//wechseln
		double euro = 10;
		assertEquals(12.9, mc.changeMoneyToDollar(euro),0.01);
		assertEquals(10.0,  mc.changeMoneyToEuro(euro),0.01);
		assertEquals(8.6, mc.changeMoneyToPound(euro),0.01);
		assertEquals(12.5, mc.changeMoneyToSFR(euro),0.01);
	}


	@Test
	public void testInvalid () {

		//ungültiger Euro Wert
		double euro = -2;
		//Testfälle mit mc
		assertEquals(0.0, mc.changeMoneyToDollar(euro),0.01);
		assertEquals(0.0, mc.changeMoneyToEuro(euro),0.01);
		assertEquals(0.0, mc.changeMoneyToPound(euro),0.01);
		assertEquals(0.0, mc.changeMoneyToSFR(euro),0.01);
	}
}

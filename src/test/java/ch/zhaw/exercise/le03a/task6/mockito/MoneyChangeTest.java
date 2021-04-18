package ch.zhaw.exercise.le03a.task6.mockito;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MoneyChangeTest {

	MoneyChange moneyChange;

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
		moneyChange = new MoneyChange(cR);
	}

	@Test
	public void testChange() {
		//wechseln
		double euro = 1;
		assertEquals(1.29, moneyChange.changeMoneyToDollar(euro),0.01);
		assertEquals(1.0,  moneyChange.changeMoneyToEuro(euro),0.01);
		assertEquals(0.86, moneyChange.changeMoneyToPound(euro),0.01);
		assertEquals(1.25, moneyChange.changeMoneyToSFR(euro),0.01);
	}

	@Test
	public void testChange10() {
		//wechseln
		double euro = 10;
		assertEquals(12.9, moneyChange.changeMoneyToDollar(euro),0.01);
		assertEquals(10.0,  moneyChange.changeMoneyToEuro(euro),0.01);
		assertEquals(8.6, moneyChange.changeMoneyToPound(euro),0.01);
		assertEquals(12.5, moneyChange.changeMoneyToSFR(euro),0.01);
	}


	@Test
	public void testInvalid () {

		//ungültiger Euro Wert
		double euro = -2;
		//Testfälle mit mc
		assertEquals(0.0, moneyChange.changeMoneyToDollar(euro),0.01);
		assertEquals(0.0, moneyChange.changeMoneyToEuro(euro),0.01);
		assertEquals(0.0, moneyChange.changeMoneyToPound(euro),0.01);
		assertEquals(0.0, moneyChange.changeMoneyToSFR(euro),0.01);
	}
}

package ch.zhaw.exercise.le03a.mockito;


public class MoneyChange {
	/**
	 * beinhaltet die Quelle aus der die Wechselkurse gelesen werden
	 */
	private ChangeRate source;

	public MoneyChange(ChangeRate source) {
		this.source = source;}

	public double changeMoneyToDollar(double euro) {
		if (euro >= 0) { return euro * this.source.getRate_EUROtoDOLLAR();}
		else { return 0.0;}
	}

	public double changeMoneyToSFR(double euro) {
		if (euro >= 0) { return euro * this.source.getRate_EUROtoSFR();}
		else { return 0.0;}
	}

	public double changeMoneyToEuro(double euro) {
		if (euro >= 0) { return euro * this.source.getRate_EUROtoEURO();}
		else { return 0.0;}
	}

	public double changeMoneyToPound(double euro) {
		if (euro >= 0) { return euro * this.source.getRate_EUROtoPOUND();}
		else { return 0.0;}
	}

}

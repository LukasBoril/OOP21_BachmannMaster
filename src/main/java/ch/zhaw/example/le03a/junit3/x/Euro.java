package ch.zhaw.example.le03a.junit3.x;

public class Euro {
	private double amount;

	public Euro(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return this.amount;
	}

	public void add (Euro euro) {
		if (euro.getAmount() <0) throw new IllegalArgumentException();
		this.amount += euro.getAmount();
	}
}

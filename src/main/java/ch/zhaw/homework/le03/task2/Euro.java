package ch.zhaw.homework.le03.task2;

public class Euro {
    private double amount;

    public Euro(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return this.amount;
    }
    public void add (ch.zhaw.example.junit.junit3.x.Euro euro) {
        if (euro.getAmount() <0) throw new IllegalArgumentException();
        this.amount += euro.getAmount();
    }
}

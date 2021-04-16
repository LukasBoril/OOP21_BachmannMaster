package ch.zhaw.exercise.le03.task5;

public class Euro {
    private double amount;

    public Euro(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public void add(Euro euro) {
        if (euro.getAmount() < 0 )
            throw new IllegalArgumentException("Amount added must be greater than 0!");
        this.amount += euro.getAmount();
    }
}

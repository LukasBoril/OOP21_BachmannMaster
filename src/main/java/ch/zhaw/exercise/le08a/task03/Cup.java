package ch.zhaw.exercise.le08a.task03;

public class Cup<T extends Drink>{

    private final T drink;

    public Cup(T drink){
        this.drink = drink;
    }

    public T getContent() {
        return this.drink;
    }

    @Override
    public String toString() {
        return "Cup contains: " + drink.getFlavour();
    }
}

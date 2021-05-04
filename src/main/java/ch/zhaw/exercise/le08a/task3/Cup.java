package ch.zhaw.exercise.le08a.task3;

public class Cup<T extends Drink> {

    private final T inhalt;

    public Cup(T inhalt) {
        this.inhalt = inhalt;
    }

    public T getContent() {
        return inhalt;
    }

    @Override
    public String toString() {
        return "Cup contains: " + inhalt.getFlavour();
    }
}
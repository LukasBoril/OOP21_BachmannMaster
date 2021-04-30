package ch.zhaw.exercise.LE08a.Task3;

public class Cup<T extends Drink> {

    private final T inhalt;

    public Cup(T inhalt) {
        this.inhalt = inhalt;
    }
    public Drink getContent() {
        return inhalt;
    }
    @Override
    public String toString() {
        return "Cup contains: " + inhalt.getFlavour();
    }
}

package ch.zhaw.exercise.LE08a.Task3;

public class Tea implements Drink {

    private final String flavour;
    public Tea(String flavour) {
        this.flavour = flavour;
    }
    public String getFlavour() {
        return flavour + " Tea";
    }
}

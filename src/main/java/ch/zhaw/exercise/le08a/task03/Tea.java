package ch.zhaw.exercise.le08a.task03;

public class Tea implements Drink{

    private final String flavour;

    public Tea(String flavour){
        this.flavour = flavour;
    }

    @Override
    public String getFlavour() {
        return this.flavour + " Tea";
    }
}

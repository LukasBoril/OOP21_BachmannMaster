package ch.zhaw.exercise.LE08a.Task3;

public class Sirup implements Drink {
    private final String flavour;
    public Sirup(String flavour) { this.flavour = flavour;
    }
    public String getFlavour() { return flavour + " Sirup";
    }
}

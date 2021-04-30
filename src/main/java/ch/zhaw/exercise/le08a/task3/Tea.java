package ch.zhaw.exercise.le08a.task3;

public class Tea implements Drink {

  private final String flavour;

  public Tea(String flavour) {
    this.flavour = flavour;
  }

  public String getFlavour() {
    return flavour + " Tea";
  }
}

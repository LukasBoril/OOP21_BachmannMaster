package ch.zhaw.exercise.le08a.task3;

public class Sirup implements Drink {

	private final String flavour;

	public Sirup(String flavour) {
		this.flavour = flavour;
	}

	@Override
	public String getFlavour() {
	    return flavour + " Sirup";
	  }

}

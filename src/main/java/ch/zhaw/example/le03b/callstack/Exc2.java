package ch.zhaw.example.le03b.callstack;

@SuppressWarnings("serial")
public class Exc2 extends Exception {

	  public Exc2() {
	    super();
	  }

	  public Exc2(String message) {
	    super(message);
	  }

	  public Exc2(Throwable cause) {
	    super(cause);
	  }
	}

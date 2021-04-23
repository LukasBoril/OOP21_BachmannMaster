package ch.zhaw.example.le03b.callstack;

@SuppressWarnings("serial")
public class Exc1 extends Exception {

	  public Exc1() {
	    super();
	  }

	  public Exc1(String message) {
	    super(message);
	  }

	  public Exc1(Throwable cause) {
	    super(cause);
	  }
	}

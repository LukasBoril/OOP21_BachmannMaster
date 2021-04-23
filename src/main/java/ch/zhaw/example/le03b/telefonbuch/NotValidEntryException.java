package ch.zhaw.example.le03b.telefonbuch;



public class NotValidEntryException extends Exception {
	private static final long serialVersionUID = 6966282460364951733L;

public NotValidEntryException(String message) {
    super(message);
  }

}

package ch.zhaw.exercise.le03b.exceptions;

@SuppressWarnings("serial")
public class MyCheckedException extends Exception {

  public MyCheckedException() {
    super();
  }

  public MyCheckedException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public MyCheckedException(String message, Throwable cause) {
    super(message, cause);
  }

  public MyCheckedException(String message) {
    super(message);
  }

  public MyCheckedException(Throwable cause) {
    super(cause);
  }
}

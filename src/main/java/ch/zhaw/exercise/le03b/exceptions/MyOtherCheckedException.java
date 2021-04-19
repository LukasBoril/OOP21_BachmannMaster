package ch.zhaw.exercise.le03b.exceptions;

@SuppressWarnings("serial")
public class MyOtherCheckedException extends Exception {

  public MyOtherCheckedException() {
  }

  public MyOtherCheckedException(String message) {
    super(message);
  }

  public MyOtherCheckedException(Throwable cause) {
    super(cause);
  }

  public MyOtherCheckedException(String message, Throwable cause) {
    super(message, cause);
  }

  public MyOtherCheckedException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}

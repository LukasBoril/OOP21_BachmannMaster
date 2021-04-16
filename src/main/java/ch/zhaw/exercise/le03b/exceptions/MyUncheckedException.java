package ch.zhaw.exercise.le03b.exceptions;

@SuppressWarnings("serial")
public class MyUncheckedException extends RuntimeException {

  public MyUncheckedException() {
  }

  public MyUncheckedException(String message) {
    super(message);
  }

  public MyUncheckedException(Throwable cause) {
    super(cause);
  }

  public MyUncheckedException(String message, Throwable cause) {
    super(message, cause);
  }

  public MyUncheckedException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}

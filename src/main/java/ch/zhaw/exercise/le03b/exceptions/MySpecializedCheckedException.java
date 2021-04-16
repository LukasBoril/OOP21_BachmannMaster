package ch.zhaw.exercise.le03b.exceptions;

@SuppressWarnings("serial")
public class MySpecializedCheckedException extends MyCheckedException {

  public MySpecializedCheckedException() {
  }

  public MySpecializedCheckedException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public MySpecializedCheckedException(String message, Throwable cause) {
    super(message, cause);
  }

  public MySpecializedCheckedException(String message) {
    super(message);
  }

  public MySpecializedCheckedException(Throwable cause) {
    super(cause);
  }

}

package ch.zhaw.exercise.le03b.exceptions;

public class Exceptions {

  // Werfen von Exceptions //
  // --------------------- //

  public void throwACheckedException() throws MyCheckedException {
    throw new MyCheckedException("Dies ist eine Checked-Exception");
  }

  public void throwASpecializedCheckedException() throws MyCheckedException {
    // Hier kann eine MyCheckedException oder eine MySpecializedCheckedException
    // eine beliebige Subklasse von MyCheckedException geworfen werden (oder gar keine, wie gerade jetzt)
    // Der aufrufer der Methode muss die Exception aber propagieren oder behandeln (auch wenn nie was kommt)
  }

  public void throwAnotherCheckedException() throws MyOtherCheckedException {
    throw new MyOtherCheckedException("Dies ist eine andere Checked-Exception");
  }

  // Deklarieren der Exception ist optional bei Unchecked Exceptions
  public void throwAnUncheckedException() {
    throw new MyUncheckedException("Dies ist eine Unchecked-Exception");
  }

  // Umgang mit Exceptions (Exception-Handling) //
  // ------------------------------------------ //

  // Checked Exceptions //
  // ------------------ //

  // Deklarieren einer Checked-Exception
  public void throwException() throws MyCheckedException {
    throwACheckedException();
  }

  // Behandeln einer Checked-Exception
  public void tryCatch() {
    try {
      throwACheckedException();
    } catch (MyCheckedException e) {
      // Loggen etc.
      e.printStackTrace();
    }
  }

  // Behandeln, und weiter werfen (propagieren) von Checked-Exceptions
  public void checkAndRethrowChecked() throws MyCheckedException {
    try {
      throwACheckedException();
    } catch (MyCheckedException e) {
      e.printStackTrace();
      throw e;
    }
  }

  // Behandeln, verpacken und neu werfen von Checked-Exceptions
  public void rethrowChecked() throws MyOtherCheckedException {
    try {
      throwACheckedException();
    } catch (MyCheckedException e) {
      e.printStackTrace();
      throw new MyOtherCheckedException("Meine andere Checked-Exception", e);
    }
  }

  // Deklarieren von mehreren Exceptions
  public void throwMultipleCheckedExceptions() throws MyCheckedException, MyOtherCheckedException {
    throwACheckedException();
    throwAnotherCheckedException();
  }

  // Behandeln von mehreren Exceptions
  public void tryCatchMultipleCheckedExceptions() {
    try {
      throwACheckedException();
      throwAnotherCheckedException();
    } catch (MyCheckedException e) {
      e.printStackTrace();
    } catch (MyOtherCheckedException e) {
      e.printStackTrace();
    }
  }

  // Behandeln von mehreren Exceptions seit Java 7
  public void tryCatchMultipleCheckedExceptionsJava7() {
    try {
      throwACheckedException();
      throwAnotherCheckedException();
    } catch (MyCheckedException | MyOtherCheckedException e) {
      e.printStackTrace();
    }
  }

  // Behandeln von Exceptions unter Beruecksichtigung der Vererbungshierarchie
  public void tryCatchInheritedExceptions() {
    try {
      throwASpecializedCheckedException();
    } catch (MySpecializedCheckedException e) {
      // Etwas tun, falls eine MySpecializedCheckedException oder eine Subklasse davon geworfen wird
      e.printStackTrace();
    } catch (MyCheckedException e) {
      // Etwas tun, falls eine MyCheckedException oder eine Subklasse davon (ausser MySpecializedCheckedException
      // und deren Subklassen, die wurde bereits oben behandelt) geworfen wird.
      e.printStackTrace();
    }
  }

  // Behandeln von allen Exceptions (schlechter Stil --> nicht empfohlen)
  public void catchAllExceptions() {
    try {
      throwACheckedException();
      throwAnotherCheckedException();
      throwAnUncheckedException();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Behandeln und neu werfen und propagieren von allen Exceptions (schlechter Stil --> nicht empfohlen)
  public void catchAllAndThrowExceptions() throws Exception {
    try {
      throwACheckedException();
      throwAnotherCheckedException();
      throwAnUncheckedException();
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  // Behandeln aller Exceptions und neu werfen und propagieren von spezifischen Exceptions (Java 7 Style)
  public void catchAllAndThrowExceptionsJava7() throws MyCheckedException, MyOtherCheckedException {
    try {
      throwACheckedException();
      throwAnotherCheckedException();
      throwAnUncheckedException();
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  // Verschachteltes Behandeln von Exceptions (mir wird ganz schwindlig...)
  public void nestedCatch() {
    try {
      throwACheckedException();
      try {
        throwAnotherCheckedException();
      } catch (MyOtherCheckedException e) {
        e.printStackTrace();
      }
    } catch (MyCheckedException e) {
      e.printStackTrace();
      try {
        throwAnotherCheckedException();
      } catch (MyOtherCheckedException e1) {
        e1.printStackTrace();
      }
    }
  }

  // Unchecked Exceptions //
  //--------------------- //

  public void throwUncheckedException() {
    throwAnUncheckedException();
  }

  // Deklarieren ist optional, hat keine Auswirkung auf den Aufrufer
  public void throwUncheckedExceptionMitThrows() throws MyUncheckedException {
    throwAnUncheckedException();
  }

  // Behandeln ist optional, darf aber gemacht werden
  public void tryCatchUnchecked() {
    try {
      throwAnUncheckedException();
    } catch (MyUncheckedException e) {
      e.printStackTrace();
    }
  }

  // catchen einer checked Exception und verpacken in eine Unchecked, deshalb muss nicht propagiert werden
  public void rethrowUnchecked() {
    try {
      throwACheckedException();
    } catch (MyCheckedException e) {
      e.printStackTrace();
      throw new MyUncheckedException("Meine Unchecked-Exception", e);
    }
  }

  // Finally
  public void tryCheckFinally() {
    try {
      throwACheckedException();
    } catch (MyCheckedException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Mach das immer, egal ob Exception oder nicht");
    }
  }

  // Finally ohne catch-Block
  public void tryFinally(String a) {
    try {
      System.out.println("Mach was, was keine Checked-Exception wirft. (evtl. wird eine Unchecked-Exception geworfen)");
      a.length();
    } finally {
      System.out.println("Mach das immer, egal ob Exception oder nicht");
    }
  }
}

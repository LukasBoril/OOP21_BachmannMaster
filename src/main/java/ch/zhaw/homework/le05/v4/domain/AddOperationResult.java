package ch.zhaw.homework.le05.v4.domain;


public class AddOperationResult {

    private boolean error;

    private String message;


    public boolean hasError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public void addErrorMessage(String errorMessage) {
        error = true;
        message = errorMessage;
    }
}

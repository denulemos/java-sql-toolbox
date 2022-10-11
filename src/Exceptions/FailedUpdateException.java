package Exceptions;

public class FailedUpdateException extends Exception {
    public FailedUpdateException(String errorMessage) {
        super(errorMessage);
    }
}

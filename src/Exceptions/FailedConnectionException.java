package Exceptions;

public class FailedConnectionException extends Exception{
    public FailedConnectionException(String errorMessage) {
        super(errorMessage);
    }
}

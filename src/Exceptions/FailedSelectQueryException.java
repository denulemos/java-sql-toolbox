package Exceptions;

public class FailedSelectQueryException extends Exception{
    public FailedSelectQueryException(String errorMessage) {
        super(errorMessage);
    }
}


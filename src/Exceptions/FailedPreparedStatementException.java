package Exceptions;

public class FailedPreparedStatementException extends Exception{
    public FailedPreparedStatementException(String errorMessage) {
        super(errorMessage);
    }
}

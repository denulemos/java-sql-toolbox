package Exceptions;

public class StoreProcedureException extends Exception{
    public StoreProcedureException(String errorMessage) {
        super(errorMessage);
    }
}

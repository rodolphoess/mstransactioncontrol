package br.transaction.control.core.exception;

public class ExistingAccountException extends RuntimeException {

    public ExistingAccountException(String message) {
        super(message);
    }
}

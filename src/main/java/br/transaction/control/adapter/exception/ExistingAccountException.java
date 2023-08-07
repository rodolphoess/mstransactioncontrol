package br.transaction.control.adapter.exception;

public class ExistingAccountException extends RuntimeException {

    public ExistingAccountException(String message) {
        super(message);
    }
}

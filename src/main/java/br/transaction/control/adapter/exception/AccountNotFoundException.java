package br.transaction.control.adapter.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String message) {
        super(message);
    }

}

package br.transaction.control.core.exception;

public class InsuficientCreditLimit extends RuntimeException {

    public InsuficientCreditLimit(String message) {
        super(message);
    }

}

package br.transaction.control.adapter.exception;

public class InsuficientCreditLimit extends RuntimeException {

    public InsuficientCreditLimit(String message) {
        super(message);
    }

}

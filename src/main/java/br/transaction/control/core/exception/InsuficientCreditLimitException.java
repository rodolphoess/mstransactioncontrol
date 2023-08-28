package br.transaction.control.core.exception;

public class InsuficientCreditLimitException extends RuntimeException {

    public InsuficientCreditLimitException(String message) {
        super(message);
    }

}

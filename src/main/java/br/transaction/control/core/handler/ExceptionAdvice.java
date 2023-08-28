package br.transaction.control.core.handler;

import br.transaction.control.adapter.exception.AccountNotFoundException;
import br.transaction.control.adapter.exception.TransactionNotFoundException;
import br.transaction.control.adapter.exception.ValidationLombokException;
import br.transaction.control.core.exception.ExistingAccountException;
import br.transaction.control.core.exception.InsuficientCreditLimitException;
import br.transaction.control.core.exception.InvalidDocumentNumberException;
import br.transaction.control.core.exception.OperationTypeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = {AccountNotFoundException.class})
    public ResponseEntity<Object> accountNotFound(
            AccountNotFoundException e
    ) {
        log.error("[HANDLER EXCEPTION] this_account_doesnt_exists: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(value = {ExistingAccountException.class})
    protected ResponseEntity<Object> existingAccount(
            ExistingAccountException e
    ) {
        log.error("[HANDLER EXCEPTION] this_account_already_exists: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(value = {OperationTypeException.class})
    protected ResponseEntity<Object> invalidOperationType(
            OperationTypeException e
    ) {
        log.error("[HANDLER EXCEPTION] this_operation_type_is_invalid: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = {InvalidDocumentNumberException.class})
    protected ResponseEntity<Object> invalidDocumentNumberException(
            InvalidDocumentNumberException e
    ) {
        log.error("[HANDLER EXCEPTION] document_number_is_invalid: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = {TransactionNotFoundException.class})
    protected ResponseEntity<Object> transactionNotFound(
            TransactionNotFoundException e
    ) {
        log.error("[HANDLER EXCEPTION] this_transaction_doesnt_exists: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(value = {InsuficientCreditLimitException.class})
    protected ResponseEntity<Object> insuficientCreditLimit(
            InsuficientCreditLimitException e
    ) {
        log.error("[HANDLER EXCEPTION] insuficient_credit_limit: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = ValidationLombokException.class)
    protected ResponseEntity<Object> validationError(
            ValidationLombokException e
    ) {
        log.error("[HANDLER EXCEPTION] validation_error: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}

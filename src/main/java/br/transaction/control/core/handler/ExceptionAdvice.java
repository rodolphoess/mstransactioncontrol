package br.transaction.control.core.handler;

import br.transaction.control.adapter.exception.AccountNotFoundException;
import br.transaction.control.adapter.exception.ExistingAccountException;
import br.transaction.control.core.exception.InvalidDocumentNumberException;
import br.transaction.control.core.exception.OperationTypeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {AccountNotFoundException.class})
    public ResponseEntity<Object> accountNotFound(
            AccountNotFoundException e,
            WebRequest webRequest
    ) {
        log.error("[HANDLER EXCEPTION] this_account_doesnt_exists: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account was not found.");
    }

    @ExceptionHandler(value = {ExistingAccountException.class})
    protected ResponseEntity<Object> existingAccount(
            ExistingAccountException e,
            WebRequest webRequest
            ) {
        log.error("[HANDLER EXCEPTION] this_account_already_exists: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body("This account already exists.");
    }

    @ExceptionHandler(value = {OperationTypeException.class})
    protected ResponseEntity<Object> invalidOperationType(
            OperationTypeException e,
            WebRequest webRequest
            ) {
        log.error("[HANDLER EXCEPTION] this_operation_type_is_invalid: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This operation type is invalid.");
    }

    @ExceptionHandler(value = {InvalidDocumentNumberException.class})
    protected ResponseEntity<Object> invalidDocumentNumberException(
            InvalidDocumentNumberException e,
            WebRequest webRequest
            ) {
        log.error("[HANDLER EXCEPTION] document_number_is_invalid: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Document number is invalid.");
    }

}

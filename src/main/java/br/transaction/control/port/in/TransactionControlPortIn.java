package br.transaction.control.port.in;

import br.transaction.control.adapter.request.CreateAccountRequest;
import br.transaction.control.adapter.request.CreateTransactionRequest;
import org.springframework.http.ResponseEntity;

public interface TransactionControlPortIn {

    ResponseEntity<Object> createAccount(CreateAccountRequest request);

    ResponseEntity<Object> getAccount(Long accountId);

    ResponseEntity<Object> createTransaction(CreateTransactionRequest request);

    ResponseEntity<Object> getTransaction(Long transactionId);

    ResponseEntity<Object> getSumTransaction(Long accountId);
}

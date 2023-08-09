package br.transaction.control.port.in;

import br.transaction.control.adapter.request.CreateAccountRequest;
import br.transaction.control.adapter.request.CreateTransactionRequest;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.CompletableFuture;

public interface TransactionControlPortIn {

    CompletableFuture<ResponseEntity<Object>> createAccount(CreateAccountRequest request);

    ResponseEntity<Object> getAccount(Long accountId);

    ResponseEntity<Object> createTransaction(CreateTransactionRequest request);
}

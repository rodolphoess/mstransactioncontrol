package br.transaction.control.port.out;

import br.transaction.control.adapter.response.AccountResponse;
import br.transaction.control.adapter.response.CreateAccountResponse;
import br.transaction.control.adapter.response.CreateTransactionResponse;
import br.transaction.control.adapter.response.TransactionResponse;
import br.transaction.control.core.model.Account;
import br.transaction.control.core.model.Transaction;

public interface TransactionControlPortOut {

    CreateAccountResponse createAccount(Account account);

    CreateTransactionResponse createTransaction(Transaction transaction);

    AccountResponse getAccount(Long accountId);

    TransactionResponse getTransaction(Long transactionId);
}

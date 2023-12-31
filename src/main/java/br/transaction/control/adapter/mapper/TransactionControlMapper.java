package br.transaction.control.adapter.mapper;

import br.transaction.control.adapter.out.entity.AccountEntity;
import br.transaction.control.adapter.out.entity.TransactionEntity;
import br.transaction.control.adapter.request.CreateAccountRequest;
import br.transaction.control.adapter.request.CreateTransactionRequest;
import br.transaction.control.adapter.response.AccountResponse;
import br.transaction.control.adapter.response.CreateAccountResponse;
import br.transaction.control.adapter.response.CreateTransactionResponse;
import br.transaction.control.adapter.response.TransactionResponse;
import br.transaction.control.adapter.response.SumTransactionsResponse;
import br.transaction.control.core.model.Account;
import br.transaction.control.core.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;

@Mapper
public interface TransactionControlMapper {

    Account requestToAccount(CreateAccountRequest request);

    AccountEntity accountToEntity(Account account);

    CreateAccountResponse accountEntityToResponse(AccountEntity entity);

    AccountResponse accountEntityToAccountResponse(AccountEntity entity);

    @Mapping(source = "accountId", target = "account.accountId")
    @Mapping(source = "operationType", target = "operation.operationId")
    Transaction transactionRequestToTransaction(CreateTransactionRequest request);

    @Mapping(source = "operation.operationId", target = "operationType")
    TransactionEntity transactionToTransactionEntity(Transaction transaction);

    @Mapping(source = "account.accountId", target = "accountId")
    CreateTransactionResponse transactionEntityToCreateTransactionResponse(TransactionEntity transactionEntity);

    @Mapping(source = "account.accountId", target = "accountId")
    TransactionResponse transactionEntityToTransactionResponse(TransactionEntity transactionEntity);

    Account accountResponseToAccount(AccountResponse response);

    @Mapping(source = "sumAmount", target = "sumAmount")
    SumTransactionsResponse valueAmountToSumTransactionsResponse(BigDecimal sumAmount);

}

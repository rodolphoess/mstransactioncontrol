package br.transaction.control.adapter.mapper;

import br.transaction.control.adapter.out.entity.AccountEntity;
import br.transaction.control.adapter.out.entity.OperationTypeEntity;
import br.transaction.control.adapter.out.entity.TransactionEntity;
import br.transaction.control.adapter.request.CreateAccountRequest;
import br.transaction.control.adapter.request.CreateTransactionRequest;
import br.transaction.control.adapter.response.AccountResponse;
import br.transaction.control.adapter.response.CreateAccountResponse;
import br.transaction.control.adapter.response.CreateTransactionResponse;
import br.transaction.control.core.model.Account;
import br.transaction.control.core.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TransactionControlMapper {

    Account requestToAccount(CreateAccountRequest request);

    AccountEntity accountToEntity(Account account);

    CreateAccountResponse accountEntityToResponse(AccountEntity entity);

    AccountResponse accountEntityToAccountResponse(AccountEntity entity);

    Transaction transactionRequestToTransaction(CreateTransactionRequest request);

    TransactionEntity transactionToTransactionEntity(Transaction transaction);

    CreateTransactionResponse transactionEntityToResponse(TransactionEntity transactionEntity);

}

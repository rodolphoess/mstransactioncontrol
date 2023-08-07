package br.transaction.control.adapter.mapper;

import br.transaction.control.adapter.out.entity.AccountEntity;
import br.transaction.control.adapter.request.CreateAccountRequest;
import br.transaction.control.adapter.response.AccountResponse;
import br.transaction.control.adapter.response.CreateAccountResponse;
import br.transaction.control.core.model.Account;
import org.mapstruct.Mapper;

@Mapper
public interface TransactionControlMapper {

    Account requestToAccount(CreateAccountRequest request);

    AccountEntity accountToEntity(Account account);

    CreateAccountResponse accountEntityToResponse(AccountEntity entity);

}

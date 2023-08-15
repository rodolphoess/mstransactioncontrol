package br.transaction.control.core.usecase;

import br.transaction.control.adapter.exception.ExistingAccountException;
import br.transaction.control.adapter.mapper.TransactionControlMapper;
import br.transaction.control.adapter.request.CreateAccountRequest;
import br.transaction.control.adapter.response.CreateAccountResponse;
import br.transaction.control.port.in.CreateAccountPortIn;
import br.transaction.control.port.out.TransactionControlPortOut;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreateAccountUseCase implements CreateAccountPortIn {

    private final TransactionControlMapper mapper = Mappers.getMapper(TransactionControlMapper.class);

    @Autowired
    private TransactionControlPortOut repository;

    @Override
    public CreateAccountResponse execute(CreateAccountRequest request) {
        var account = mapper.requestToAccount(request)
                .removeSpecialCharactersFromDocumentNumber()
                .defineAccountType();
        var accountExists = repository.getAccountByDocumentNumber(request.getDocumentNumber());
        if (accountExists.isPresent()) {
            throw new ExistingAccountException("This account already exists.");
        }
        log.info("[USE CASE] account_to_be_save: {}", account);
        return repository.createAccount(account);
    }

}

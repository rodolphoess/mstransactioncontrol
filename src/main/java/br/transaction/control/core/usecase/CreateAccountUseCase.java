package br.transaction.control.core.usecase;

import br.transaction.control.adapter.mapper.TransactionControlMapper;
import br.transaction.control.adapter.request.CreateAccountRequest;
import br.transaction.control.port.out.TransactionControlPortOut;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountUseCase {

    private final TransactionControlMapper mapper = Mappers.getMapper(TransactionControlMapper.class);

    @Autowired
    private TransactionControlPortOut repository;

    public void execute(CreateAccountRequest request) {
        var account = mapper.requestToAccount(request);
        repository.createAccount(account);
    }

}

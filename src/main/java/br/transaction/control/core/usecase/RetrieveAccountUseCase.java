package br.transaction.control.core.usecase;

import br.transaction.control.adapter.response.AccountResponse;
import br.transaction.control.port.in.RetrieveAccountPortIn;
import br.transaction.control.port.out.TransactionControlPortOut;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RetrieveAccountUseCase implements RetrieveAccountPortIn {

    @Autowired
    private TransactionControlPortOut repository;

    @Override
    public AccountResponse execute(Long accountId) {
        return repository.getAccountById(accountId);
    }
}

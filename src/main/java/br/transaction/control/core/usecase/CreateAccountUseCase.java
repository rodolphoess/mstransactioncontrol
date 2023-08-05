package br.transaction.control.core.usecase;

import br.transaction.control.adapter.request.CreateAccountRequest;
import br.transaction.control.port.out.TransactionControlPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountUseCase {

    @Autowired
    private TransactionControlPortOut repository;

    public void execute(CreateAccountRequest request) {

    }

}

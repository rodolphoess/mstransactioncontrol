package br.transaction.control.core.usecase;

import br.transaction.control.adapter.mapper.TransactionControlMapper;
import br.transaction.control.adapter.request.CreateTransactionRequest;
import br.transaction.control.adapter.response.CreateTransactionResponse;
import br.transaction.control.port.in.CreateTransactionPortIn;
import br.transaction.control.port.out.TransactionControlPortOut;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreateTransactionUseCase implements CreateTransactionPortIn {

    private final TransactionControlMapper mapper = Mappers.getMapper(TransactionControlMapper.class);

    @Autowired
    private TransactionControlPortOut repository;

    @Override
    public CreateTransactionResponse execute(CreateTransactionRequest request) {
        var transaction = mapper.transactionRequestToTransaction(request)
                .buildOperation(request.getOperationType())
                .reviewValueOfAmount()
                .createDateTimeOfTransaction();
        log.info("[USE CASE] transaction_to_create: {}", transaction);
        var transactionSaved = repository.createTransaction(transaction);
        log.info("[USE CASE] transaction_saved: {}", transactionSaved);
        return transactionSaved;
    }

}

package br.transaction.control.core.usecase;

import br.transaction.control.adapter.response.TransactionResponse;
import br.transaction.control.core.model.Operation;
import br.transaction.control.port.in.RetrieveTransactionPortIn;
import br.transaction.control.port.out.TransactionControlPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetrieveTransactionUseCase implements RetrieveTransactionPortIn {

    @Autowired
    private TransactionControlPortOut repository;

    @Override
    public TransactionResponse execute(Long transactionId) {
        var response = repository.getTransaction(transactionId);
        var operation = buildOperation(response);
        response.setOperation(operation.getOperationType());
        return response;
    }

    private static Operation buildOperation(TransactionResponse response) {
        return Operation.builder().build()
                .defineOperationType(response.getOperationType());
    }
}

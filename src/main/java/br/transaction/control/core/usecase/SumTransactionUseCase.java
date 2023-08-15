package br.transaction.control.core.usecase;

import br.transaction.control.adapter.mapper.TransactionControlMapper;
import br.transaction.control.adapter.response.SumTransactionsResponse;
import br.transaction.control.port.in.SumTransactionPortIn;
import br.transaction.control.port.out.TransactionControlPortOut;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SumTransactionUseCase implements SumTransactionPortIn {

    private final TransactionControlMapper mapper = Mappers.getMapper(TransactionControlMapper.class);

    @Autowired
    private TransactionControlPortOut repository;

    @Override
    public SumTransactionsResponse execute(Long accountId) {
        var sumAmount = repository.getAmountSum(accountId);
        return mapper.valueAmountToSumTransactionsResponse(sumAmount);
    }

}

package br.transaction.control.core.usecase;

import br.transaction.control.adapter.mapper.TransactionControlMapper;
import br.transaction.control.adapter.request.CreateTransactionRequest;
import br.transaction.control.adapter.response.CreateTransactionResponse;
import br.transaction.control.core.exception.InsuficientCreditLimitException;
import br.transaction.control.port.in.CreateTransactionPortIn;
import br.transaction.control.port.out.TransactionControlPortOut;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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
        var account = repository.getAccountById(transaction.getAccount().getAccountId());
        transaction.setAccount(mapper.accountResponseToAccount(account));
        var newCreditLimit = evaluateNewCreditLimit(account.getCreditLimit(), transaction.getAmount());
        checkCreditLimitAfterTransaction(newCreditLimit);
        repository.changeCreditLimit(newCreditLimit, account.getAccountId());
        var transactionSaved = repository.createTransaction(transaction);
        log.info("[USE CASE] transaction_saved: {}", transactionSaved);
        return transactionSaved;
    }

    private static void checkCreditLimitAfterTransaction(BigDecimal newCreditLimit) {
        if (newCreditLimit.compareTo(BigDecimal.ZERO) < 0) {
            throw new InsuficientCreditLimitException("You don't have credit limit for this transaction.");
        }
    }

    private BigDecimal evaluateNewCreditLimit(BigDecimal creditLimit, BigDecimal amount) {
        return creditLimit.add(amount);
    }

}

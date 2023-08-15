package br.transaction.control.adapter.out;

import br.transaction.control.adapter.exception.AccountNotFoundException;
import br.transaction.control.adapter.exception.ExistingAccountException;
import br.transaction.control.adapter.exception.TransactionNotFoundException;
import br.transaction.control.adapter.mapper.TransactionControlMapper;
import br.transaction.control.adapter.out.jpa.AccountJpaRepository;
import br.transaction.control.adapter.out.jpa.TransactionJpaRepository;
import br.transaction.control.adapter.response.AccountResponse;
import br.transaction.control.adapter.response.CreateAccountResponse;
import br.transaction.control.adapter.response.CreateTransactionResponse;
import br.transaction.control.adapter.response.TransactionResponse;
import br.transaction.control.core.model.Account;
import br.transaction.control.core.model.Transaction;
import br.transaction.control.port.out.TransactionControlPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Slf4j
@Repository
@Transactional
@AllArgsConstructor
public class TransactionControlRepository implements TransactionControlPortOut {

    private final TransactionControlMapper mapper = Mappers.getMapper(TransactionControlMapper.class);

    private AccountJpaRepository accountJpaRepository;
    private TransactionJpaRepository transactionJpaRepository;

    @Override
    public CreateAccountResponse createAccount(Account account) {
        var savedAccount = accountJpaRepository.save(mapper.accountToEntity(account));
        log.info("[REPOSITORY] saved_account: {}", savedAccount);
        return mapper.accountEntityToResponse(savedAccount);
    }

    @Override
    public CreateTransactionResponse createTransaction(Transaction transaction) {
        var entity = mapper.transactionToTransactionEntity(transaction);
        log.info("[REPOSITORY] transaction_to_save: {}", entity);
        var transactionEntity = transactionJpaRepository.save(entity);
        log.info("[REPOSITORY] transaction_saved_with_id: {}", transactionEntity.getTransactionId());
        return mapper.transactionEntityToCreateTransactionResponse(transactionEntity);
    }

    @Override
    public AccountResponse getAccountById(Long accountId) {
        var accountEntity = accountJpaRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found for id " + accountId));
        log.info("[REPOSITORY] retrivied_account_from_account_id: {}", accountEntity);
        return mapper.accountEntityToAccountResponse(accountEntity);
    }

    @Override
    public Optional<AccountResponse> getAccountByDocumentNumber(String documentNumber) {
        var account = accountJpaRepository.findByDocumentNumber(documentNumber);
        return account.map(mapper::accountEntityToAccountResponse);
    }

    @Override
    public TransactionResponse getTransaction(Long transactionId) {
        log.info("[REPOSITORY] retrieve_transaction_of_id {}", transactionId);
        var transactionEntity = transactionJpaRepository.findById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException("The transaction doesn't exists."));
        log.info("[REPOSITORY] retrivied_transaction: {}", transactionEntity);
        return mapper.transactionEntityToTransactionResponse(transactionEntity);
    }

}

package br.transaction.control.adapter.out.jpa;

import br.transaction.control.adapter.out.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, Long> {

    @Query(value = "select * from account acc where acc.document_number = :documentNumber", nativeQuery = true)
    Optional<AccountEntity> findByDocumentNumber(@Param("documentNumber") String documentNumber);

    @Query(value = "update account set credit_limit = :creditLimit where account_id = :accountId", nativeQuery = true)
    @Modifying
    void changeCreditLimit(@Param("creditLimit") BigDecimal creditLimit,
                           @Param("accountId") Long accountId);

}

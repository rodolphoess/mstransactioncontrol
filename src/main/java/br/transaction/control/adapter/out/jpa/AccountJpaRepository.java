package br.transaction.control.adapter.out.jpa;

import br.transaction.control.adapter.out.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, Long> {

    @Query(value = "select * from account acc where acc.document_number = :documentNumber", nativeQuery = true)
    Optional<AccountEntity> findByDocumentNumber(@Param("documentNumber") String documentNumber);

}

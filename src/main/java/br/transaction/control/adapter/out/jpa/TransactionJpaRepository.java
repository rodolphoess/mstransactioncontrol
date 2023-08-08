package br.transaction.control.adapter.out.jpa;

import br.transaction.control.adapter.out.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, Long> {

    @Query(value = "SELECT SUM(amount) AS total_amount FROM transaction " +
            "WHERE account_id = :accountId " +
            "AND event_date >= CURRENT_DATE - INTERVAL :days DAY", nativeQuery = true)
    BigDecimal sumOfAmountOnTheLast30Days(@Param("accountId") Long accountId,
                                          @Param("days") Long days);

}

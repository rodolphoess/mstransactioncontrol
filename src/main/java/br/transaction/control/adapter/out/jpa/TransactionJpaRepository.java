package br.transaction.control.adapter.out.jpa;

import br.transaction.control.adapter.out.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, Long> { }

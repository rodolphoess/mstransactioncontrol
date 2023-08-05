package br.transaction.control.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    private Integer transactionId;
    private Account account;
    private OperationType operationType;
    private BigDecimal amount;

}

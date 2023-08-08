package br.transaction.control.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    private Long transactionId;
    private Account account;
    private Operation operation;
    private BigDecimal amount;
    private LocalDateTime eventDate;

    public Transaction buildOperation(Long operationId) {
        this.operation = operation.defineOperationType(operationId);
        return this;
    }

    public Transaction reviewValueOfAmount() {
        if (isOperationDifferentOfPayment()) {
            this.amount = amount.negate();
        }
        return this;
    }

    public Transaction createDateTimeOfTransaction() {
        this.eventDate = LocalDateTime.now();
        return this;
    }

    private boolean isOperationDifferentOfPayment() {
        return !operation.getOperationType().equals(OperationType.PAGAMENTO);
    }

}

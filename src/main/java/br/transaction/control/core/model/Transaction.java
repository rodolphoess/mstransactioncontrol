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

    private Long accountId;
    private Account account;
    private Long operationType;
    private OperationType operationTypeDescription;
    private BigDecimal amount;
    private LocalDateTime eventDate;

    public Transaction defineOperationType() {
        if (this.operationType.equals(OperationType.COMPRA_A_VISTA.getType())) {
            this.operationTypeDescription = OperationType.COMPRA_A_VISTA;
            return this;
        }

        if (this.operationType.equals(OperationType.COMPRA_PARCELADA.getType())) {
            this.operationTypeDescription = OperationType.COMPRA_PARCELADA;
            return this;
        }

        if (this.operationType.equals(OperationType.SAQUE.getType())) {
            this.operationTypeDescription = OperationType.SAQUE;
            return this;
        }

        if (this.operationType.equals(OperationType.PAGAMENTO.getType())) {
            this.operationTypeDescription = OperationType.PAGAMENTO;
            return this;
        }
        return this;
    }

    public Transaction reviewValueOfAmount() {
        if (operationTypeDescription.equals(OperationType.PAGAMENTO)) {
            this.amount = amount.negate();
        }
        return this;
    }

    public Transaction createDateTimeOfTransaction() {
        this.eventDate = LocalDateTime.now();
        return this;
    }

}

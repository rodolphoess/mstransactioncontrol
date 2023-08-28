package br.transaction.control.adapter.request;

import br.transaction.control.adapter.exception.ValidationLombokException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransactionRequest {

    @NotNull
    private Long accountId;

    @NotNull
    private Long operationType;

    @NotNull
    @Positive
    private BigDecimal amount;

    public void setAccountId(Long accountId) {
        if (accountId == null) {
            throw new ValidationLombokException("Invalid field of account.");
        }
        this.accountId = accountId;
    }

    public void setOperationType(Long operationType) {
        if (operationType == null) {
            throw new ValidationLombokException("Invalid field of operation type.");
        }
        this.operationType = operationType;
    }

    public void setAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new ValidationLombokException("Invalid field of amount.");
        }
        this.amount = amount;
    }

}

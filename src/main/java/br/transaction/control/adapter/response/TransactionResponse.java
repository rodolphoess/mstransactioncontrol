package br.transaction.control.adapter.response;

import br.transaction.control.core.model.OperationType;
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
public class TransactionResponse {

    private Long transactionId;
    private Long accountId;
    private Long operationType;
    private OperationType operation;
    private BigDecimal amount;
    private LocalDateTime eventDate;

}

package br.transaction.control.adapter.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransactionResponse {

    private Long transactionId;
    private Long accountId;
    private Long operationType;
    private BigDecimal amount;
    private LocalDateTime eventDate;

}

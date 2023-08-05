package br.transaction.control.adapter.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransactionResponse {

    private Integer transactionId;
    private Integer accountId;
    private Integer operationType;
    private BigDecimal amount;

}

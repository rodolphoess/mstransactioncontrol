package br.transaction.control.adapter.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransactionRequest {

    private Long accountId;
    private Integer operationType;
    private BigDecimal amount;

}

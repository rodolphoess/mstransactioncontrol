package br.transaction.control.adapter.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransactionRequest {

    private Long accountId;
    private Long operationType;
    @Positive
    private BigDecimal amount;

}

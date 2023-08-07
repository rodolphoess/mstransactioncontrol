package br.transaction.control.adapter.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountResponse {

    private Long accountId;
    private String documentNumber;
    private String accountType;

}

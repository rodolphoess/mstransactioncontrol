package br.transaction.control.adapter.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountResponse {

    private Integer accountId;
    private String documentNumber;

}

package br.transaction.control.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Integer accountId;
    private String documentNumber;
    private String accountType;

}

package br.transaction.control.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OperationType {

    COMPRA_A_VISTA(1L),
    COMPRA_PARCELADA(2L),
    SAQUE(3L),
    PAGAMENTO(4L);

    private final Long type;

}

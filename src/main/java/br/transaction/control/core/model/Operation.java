package br.transaction.control.core.model;

import br.transaction.control.core.exception.OperationTypeException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Operation {

    private Long operationId;
    private OperationType operationType;

    public Operation defineOperationType(Long operationId) {
        this.operationId = operationId;

        if (this.operationId.equals(OperationType.COMPRA_A_VISTA.getId())) {
            this.operationType = OperationType.COMPRA_A_VISTA;
            return this;
        }

        if (this.operationId.equals(OperationType.COMPRA_PARCELADA.getId())) {
            this.operationType = OperationType.COMPRA_PARCELADA;
            return this;
        }

        if (this.operationId.equals(OperationType.SAQUE.getId())) {
            this.operationType = OperationType.SAQUE;
            return this;
        }

        if (this.operationId.equals(OperationType.PAGAMENTO.getId())) {
            this.operationType = OperationType.PAGAMENTO;
            return this;
        }

        if (this.operationType == null) {
            throw new OperationTypeException("This operation type isn't valid.");
        }
        return this;
    }

}

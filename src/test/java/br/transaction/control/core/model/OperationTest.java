package br.transaction.control.core.model;

import br.transaction.control.MockFactory;
import br.transaction.control.core.exception.OperationTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    private Operation operation;

    @BeforeEach
    void setUp() {
        operation = Operation.builder().build();
    }

    @Test
    @DisplayName("Check the correct definition to operation 1")
    void checkTheCorrectDefinitionToOperation1() {
        operation = operation.defineOperationType(MockFactory.OPERATION_TYPE_1);
        assertEquals(OperationType.COMPRA_A_VISTA, operation.getOperationType());
    }

    @Test
    @DisplayName("Check the correct definition to operation 2")
    void checkTheCorrectDefinitionToOperation2() {
        operation = operation.defineOperationType(MockFactory.OPERATION_TYPE_2);
        assertEquals(OperationType.COMPRA_PARCELADA, operation.getOperationType());
    }

    @Test
    @DisplayName("Check the correct definition to operation 3")
    void checkTheCorrectDefinitionToOperation3() {
        operation = operation.defineOperationType(MockFactory.OPERATION_TYPE_3);
        assertEquals(OperationType.SAQUE, operation.getOperationType());
    }

    @Test
    @DisplayName("Check the correct definition to operation 4")
    void checkTheCorrectDefinitionToOperation4() {
        operation = operation.defineOperationType(MockFactory.OPERATION_TYPE_4);
        assertEquals(OperationType.PAGAMENTO, operation.getOperationType());
    }

    @Test
    @DisplayName("Check the correct definition to undefined operation")
    void checkTheCorrectDefinitionToUndefinedOperation() {
        assertThrows(OperationTypeException.class, () -> operation.defineOperationType(MockFactory.OPERATION_TYPE_UNDEFINED));
    }

}
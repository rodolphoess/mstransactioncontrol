package br.transaction.control.core.model;

import br.transaction.control.MockFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    private Transaction transaction;

    @BeforeEach
    void setUp() {
        transaction = Transaction.builder()
                .transactionId(MockFactory.TRANSACTION_ID)
                .account(MockFactory.buildAccount())
                .operation(Operation.builder().build())
                .amount(MockFactory.AMOUNT)
                .build();
    }

    @Test
    @DisplayName("Check if transaction will be created correctly for operation 1.")
    void checkIfTransactionWillBeCreatedCorrectlyForOperation1() {
        transaction = transaction.createDateTimeOfTransaction()
                .buildOperation(MockFactory.OPERATION_TYPE_1)
                .reviewValueOfAmount();
        int result = transaction.getAmount().compareTo(BigDecimal.ZERO);
        assertEquals(1L, transaction.getOperation().getOperationId());
        assertEquals(OperationType.COMPRA_A_VISTA, transaction.getOperation().getOperationType());
        assertTrue(result < 0);
        assertNotNull(transaction.getEventDate());
    }

    @Test
    @DisplayName("Check if transaction will be created correctly for operation 4.")
    void checkIfTransactionWillBeCreatedCorrectlyForOperation4() {
        transaction = transaction.createDateTimeOfTransaction()
                .buildOperation(MockFactory.OPERATION_TYPE_4)
                .reviewValueOfAmount();
        assertEquals(4L, transaction.getOperation().getOperationId());
        assertEquals(OperationType.PAGAMENTO, transaction.getOperation().getOperationType());
        int result = transaction.getAmount().compareTo(BigDecimal.ZERO);
        assertTrue(result > 0);
        assertNotNull(transaction.getEventDate());
    }

}
package br.transaction.control.core.usecase;

import br.transaction.control.MockFactory;
import br.transaction.control.port.out.TransactionControlPortOut;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateTransactionUseCaseTest {

    @Mock private TransactionControlPortOut repository;

    @InjectMocks private CreateTransactionUseCase useCase;

    @Test
    @DisplayName("Test if an transaction was created correctly")
    void testIfAnTransactionWasCreatedCorrectly() {
        var request = MockFactory.createTransactionRequest();
        when(repository.createTransaction(any())).thenReturn(MockFactory.createTransactionResponse());
        var result = useCase.execute(request);
        assertNotNull(result);
    }

}
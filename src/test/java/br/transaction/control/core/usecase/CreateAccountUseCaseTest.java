package br.transaction.control.core.usecase;

import br.transaction.control.MockFactory;
import br.transaction.control.port.out.TransactionControlPortOut;
import org.junit.jupiter.api.BeforeEach;
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
class CreateAccountUseCaseTest {

    @Mock private TransactionControlPortOut repository;

    @InjectMocks private CreateAccountUseCase useCase;

    @Test
    @DisplayName("Test if an account was created correctly")
    void testIfAnAccountWasCreatedCorrectly() {
        var request = MockFactory.createAccountRequest();
        when(repository.createAccount(any())).thenReturn(MockFactory.createAccountResponse());
        var result = useCase.execute(request);
        assertNotNull(result);
    }


}
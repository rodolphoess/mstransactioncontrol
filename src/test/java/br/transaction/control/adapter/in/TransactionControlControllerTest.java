package br.transaction.control.adapter.in;

import br.transaction.control.MockFactory;
import br.transaction.control.port.in.CreateAccountPortIn;
import br.transaction.control.port.in.CreateTransactionPortIn;
import br.transaction.control.port.in.RetrieveAccountPortIn;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TransactionControlControllerTest {

    @Mock
    private CreateAccountPortIn createAccountUseCase;
    @Mock
    private RetrieveAccountPortIn retrieveAccountPortIn;
    @Mock
    private CreateTransactionPortIn createTransactionUseCase;

    @InjectMocks
    private TransactionControlController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        RestAssuredMockMvc.standaloneSetup(controller);
    }

    @Test
    @DisplayName("Test create account with success")
    void testCreateAccount() {
        var request = MockFactory.createAccountRequest();
        var response = MockFactory.createAccountResponse();

        when(createAccountUseCase.execute(any())).thenReturn(response);

        given()
                .contentType("application/json")
                .body(request)
                .when()
                .post("/account")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    @DisplayName("Test get account with success")
    void testGetAccount() {
        Long accountId = 1L;
        var response = MockFactory.accountResponse();

        when(retrieveAccountPortIn.execute(accountId)).thenReturn(response);

        given()
                .when()
                .get("/account/{accountId}", accountId)
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("accountId", equalTo(response.getAccountId().intValue()))
                .body("documentNumber", equalTo(response.getDocumentNumber()))
                .body("accountType", equalTo(response.getAccountType()));
    }

    @Test
    @DisplayName("Test create transaction with success")
    void testCreateTransaction() {
        var request = MockFactory.createTransactionRequest();
        var response = MockFactory.createTransactionResponse();

        when(createTransactionUseCase.execute(any())).thenReturn(response);

        given()
                .contentType("application/json")
                .body(request)
                .when()
                .post("/transaction")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }
}
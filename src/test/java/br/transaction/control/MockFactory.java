package br.transaction.control;

import br.transaction.control.adapter.request.CreateAccountRequest;
import br.transaction.control.adapter.request.CreateTransactionRequest;
import br.transaction.control.adapter.response.CreateAccountResponse;
import br.transaction.control.adapter.response.CreateTransactionResponse;
import br.transaction.control.core.model.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MockFactory {

    public static final Long ACCOUNT_ID = 1L;
    public static final String DOCUMENT_NUMBER_CNPJ = "20.652.290/0001-65";
    public static final String DOCUMENT_NUMBER_CPF = "617.357.970-73";
    public static final String ACCOUNT_TYPE = "PF";
    public static final Long OPERATION_TYPE_1 = 1L;
    public static final Long OPERATION_TYPE_2 = 2L;
    public static final Long OPERATION_TYPE_3 = 3L;
    public static final Long OPERATION_TYPE_4 = 4L;
    public static final Long OPERATION_TYPE_UNDEFINED = 5L;
    public static final Long TRANSACTION_ID = 1L;
    public static final BigDecimal AMOUNT = BigDecimal.valueOf(145.90);
    private static final LocalDateTime EVENT_DATE = LocalDateTime.now();

    public static Account buildAccount() {
        var account = Account.builder()
                .accountId(ACCOUNT_ID)
                .documentNumber(DOCUMENT_NUMBER_CPF)
                .build();
        return account.removeSpecialCharactersFromDocumentNumber()
                .defineAccountType();
    }

    public static CreateAccountRequest createAccountRequest() {
        return CreateAccountRequest.builder()
                .documentNumber(DOCUMENT_NUMBER_CPF)
                .build();
    }

    public static CreateAccountResponse createAccountResponse() {
        return CreateAccountResponse.builder()
                .accountId(ACCOUNT_ID)
                .accountType(ACCOUNT_TYPE)
                .documentNumber(DOCUMENT_NUMBER_CPF)
                .build();
    }

    public static CreateTransactionRequest createTransactionRequest() {
        return CreateTransactionRequest.builder()
                .accountId(ACCOUNT_ID)
                .operationType(OPERATION_TYPE_2)
                .amount(AMOUNT)
                .build();
    }

    public static CreateTransactionResponse createTransactionResponse() {
        return CreateTransactionResponse.builder()
                .transactionId(TRANSACTION_ID)
                .accountId(ACCOUNT_ID)
                .operationType(OPERATION_TYPE_2)
                .amount(AMOUNT)
                .eventDate(EVENT_DATE)
                .build();
    }
}

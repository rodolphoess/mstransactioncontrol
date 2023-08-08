package br.transaction.control.core.model;

import br.transaction.control.MockFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = Account.builder()
                .accountId(MockFactory.ACCOUNT_ID)
                .build();
    }

    @Test
    @DisplayName("Test if the account type will be set correctly with a CNPJ.")
    void testIfAccountTypeWillBeSetCorrectlyWithCNPJ() {
        account.setDocumentNumber(MockFactory.DOCUMENT_NUMBER_CNPJ);
        account = account.removeSpecialCharactersFromDocumentNumber()
                .defineAccountType();
        assertEquals("PJ", account.getAccountType());
    }

    @Test
    @DisplayName("Test if the account type will be set correctly with a CPF.")
    void testIfAccountTypeWillBeSetCorrectlyWithCPF() {
        account.setDocumentNumber(MockFactory.DOCUMENT_NUMBER_CPF);
        account = account.removeSpecialCharactersFromDocumentNumber()
                .defineAccountType();
        assertEquals("PF", account.getAccountType());
    }

}
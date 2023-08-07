package br.transaction.control.core.model;

import br.transaction.control.core.exception.InvalidDocumentNumberException;
import com.danielfariati.validator.CNPJValidator;
import com.danielfariati.validator.CPFValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Long accountId;
    private String documentNumber;
    private String accountType;

    public Account removeSpecialCharactersFromDocumentNumber() {
        documentNumber = documentNumber.replaceAll("[^0-9]", "");
        return this;
    }

    public Account validateDocumentNumber() {
        var cnpj = new CNPJValidator();
        var cpf = new CPFValidator();
        if (cnpj.isValid(documentNumber, null)) {
            this.accountType = "PJ";
            return this;
        }
        if (cpf.isValid(documentNumber, null)) {
            this.accountType = "PF";
            return this;
        }
        if (accountType == null) {
            throw new InvalidDocumentNumberException("Invalid document number was informed.");
        }
        return this;
    }

}

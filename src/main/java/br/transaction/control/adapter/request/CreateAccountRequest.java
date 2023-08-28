package br.transaction.control.adapter.request;

import br.transaction.control.adapter.exception.ValidationLombokException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequest {

    @NotNull(message = "The field document number are invalid.")
    @NotBlank(message = "The field document number are invalid.")
    private String documentNumber;
    @NotNull(message = "The field credit limit are invalid.")
    @Positive(message = "The field credit limit are invalid.")
    private BigDecimal creditLimit;

    public void setDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.isEmpty()) {
            throw new ValidationLombokException("The field document number are invalid.");
        }
        this.documentNumber = documentNumber;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        if (creditLimit == null || creditLimit.compareTo(BigDecimal.ZERO) < 0) {
            throw new ValidationLombokException("The field credit limit are invalid.");
        }
        this.creditLimit = creditLimit;
    }
}

package br.transaction.control.port.in;

import br.transaction.control.adapter.response.TransactionResponse;

public interface RetrieveTransactionPortIn {

    TransactionResponse execute(Long transactionId);

}

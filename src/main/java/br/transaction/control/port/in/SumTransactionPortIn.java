package br.transaction.control.port.in;

import br.transaction.control.adapter.response.SumTransactionsResponse;

public interface SumTransactionPortIn {

    SumTransactionsResponse execute(Long accountId);

}

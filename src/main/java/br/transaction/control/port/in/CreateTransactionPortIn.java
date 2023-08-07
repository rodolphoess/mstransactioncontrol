package br.transaction.control.port.in;

import br.transaction.control.adapter.request.CreateTransactionRequest;
import br.transaction.control.adapter.response.CreateTransactionResponse;

public interface CreateTransactionPortIn {

    CreateTransactionResponse execute(CreateTransactionRequest request);

}

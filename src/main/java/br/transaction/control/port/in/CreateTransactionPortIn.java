package br.transaction.control.port.in;

import br.transaction.control.adapter.request.CreateTransactionRequest;

public interface CreateTransactionPortIn {

    void execute(CreateTransactionRequest request);

}

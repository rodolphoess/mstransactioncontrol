package br.transaction.control.port.in;

import br.transaction.control.adapter.request.CreateAccountRequest;

public interface CreateAccountPortIn {

    void execute(CreateAccountRequest request);

}

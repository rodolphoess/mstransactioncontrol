package br.transaction.control.port.in;

import br.transaction.control.adapter.request.CreateAccountRequest;
import br.transaction.control.adapter.response.CreateAccountResponse;

public interface CreateAccountPortIn {

    CreateAccountResponse execute(CreateAccountRequest request);

}

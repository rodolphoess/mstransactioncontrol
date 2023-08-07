package br.transaction.control.port.in;

import br.transaction.control.adapter.response.AccountResponse;

public interface RetrieveAccountPortIn {

    AccountResponse execute(Long accountId);

}

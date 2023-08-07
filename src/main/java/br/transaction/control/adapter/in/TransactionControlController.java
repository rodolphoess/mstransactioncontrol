package br.transaction.control.adapter.in;

import br.transaction.control.adapter.request.CreateAccountRequest;
import br.transaction.control.adapter.request.CreateTransactionRequest;
import br.transaction.control.core.usecase.CreateAccountUseCase;
import br.transaction.control.port.in.TransactionControlPortIn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TransactionControlController implements TransactionControlPortIn {

    private final CreateAccountUseCase createAccountUseCase;

    @Override
    @PostMapping("account")
    public ResponseEntity<Object> createAccount(@RequestBody @Valid CreateAccountRequest request) {
        log.info("[CONTROLLER] create_account_request: {}", request);
        createAccountUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Account was created with success!");
    }

    @Override
    public ResponseEntity<Object> getAccount(Long accountId) {
        return null;
    }

    @Override
    public ResponseEntity<Object> createTransaction(CreateTransactionRequest request) {
        return null;
    }

}

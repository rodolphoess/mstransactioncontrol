package br.transaction.control.adapter.in;

import br.transaction.control.adapter.request.CreateAccountRequest;
import br.transaction.control.adapter.request.CreateTransactionRequest;
import br.transaction.control.port.in.CreateAccountPortIn;
import br.transaction.control.port.in.CreateTransactionPortIn;
import br.transaction.control.port.in.RetrieveAccountPortIn;
import br.transaction.control.port.in.TransactionControlPortIn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TransactionControlController implements TransactionControlPortIn {

    private final CreateAccountPortIn createAccountUseCase;
    private final RetrieveAccountPortIn retrieveAccountPortIn;
//    private final CreateTransactionPortIn createTransactionUseCase;

    @Override
    @PostMapping("account")
    public ResponseEntity<Object> createAccount(@RequestBody @Valid CreateAccountRequest request) {
        log.info("[CONTROLLER] create_account_request: {}", request);
        createAccountUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Account was created with success!");
    }

    @Override
    @GetMapping("account/{accountId}")
    public ResponseEntity<Object> getAccount(@PathVariable Long accountId) {
        log.info("[CONTROLLER] starting_get_account_by_id: {}", accountId);
        var account = retrieveAccountPortIn.execute(accountId);
        return ResponseEntity.ok().body(account);
    }

    @Override
    public ResponseEntity<Object> createTransaction(CreateTransactionRequest request) {
        return null;
    }

}

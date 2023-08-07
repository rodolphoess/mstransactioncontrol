package br.transaction.control.adapter.in;

import br.transaction.control.adapter.exception.AccountNotFoundException;
import br.transaction.control.adapter.exception.ExistingAccountException;
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
    private final CreateTransactionPortIn createTransactionUseCase;

    @Override
    @PostMapping("account")
    public ResponseEntity<Object> createAccount(@RequestBody @Valid CreateAccountRequest request) {
        try {
            log.info("[CONTROLLER] create_account_request: {}", request);
            createAccountUseCase.execute(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("The account was created with success!");
        }
//        catch (ExistingAccountException e) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("This account already exists.");
//        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This account already exists.");
        }
    }

    @Override
    @GetMapping("account/{accountId}")
    public ResponseEntity<Object> getAccount(@PathVariable Long accountId) {
        try {
            log.info("[CONTROLLER] starting_get_account_by_id: {}", accountId);
            var account = retrieveAccountPortIn.execute(accountId);
            return ResponseEntity.ok().body(account);
        } catch (AccountNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account was not found.");
        }
    }

    @Override
    @PostMapping("transaction")
    public ResponseEntity<Object> createTransaction(@RequestBody @Valid CreateTransactionRequest request) {
        try {
            log.info("[CONTROLLER] create_transaction_request: {}", request);
            createTransactionUseCase.execute(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("The transaction was created with success!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error ocurred when trying create a transaction");
        }
    }

}

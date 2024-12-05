package by.itacademy.userservice.controller;

import by.itacademy.userservice.dto.AccountCreateRequest;
import by.itacademy.userservice.dto.AccountResponse;
import by.itacademy.userservice.model.Account;
import by.itacademy.userservice.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody AccountCreateRequest accountCreateRequest) {
        Account account = accountService.createAccount(accountCreateRequest);
        return ResponseEntity.status(201).body(new AccountResponse(account));
    }

    @GetMapping
    public ResponseEntity<List<AccountResponse>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(AccountResponse.from(accounts));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<AccountResponse> getAccountById(@PathVariable UUID uuid) {
        Account account = accountService.getAccountById(uuid);
        return ResponseEntity.ok(new AccountResponse(account));
    }

    @PutMapping("/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<AccountResponse> updateAccount(
            @PathVariable UUID uuid,
            @PathVariable long dt_update,
            @Valid @RequestBody AccountCreateRequest accountCreateRequest) {
        Account account = accountService.updateAccount(uuid, dt_update, accountCreateRequest);
        return ResponseEntity.ok(new AccountResponse(account));
    }
}
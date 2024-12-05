package by.itacademy.userservice.service;

import by.itacademy.userservice.dto.AccountCreateRequest;
import by.itacademy.userservice.exception.AccountNotFoundException;
import by.itacademy.userservice.model.Account;
import by.itacademy.userservice.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Account createAccount(AccountCreateRequest request) {
        Account account = new Account();
        account.setTitle(request.getTitle());
        account.setDescription(request.getDescription());
        account.setType(request.getType());
        account.setCurrency(request.getCurrency());
        account.setBalance(0.0); // Начальный баланс
        account.setDt_create(System.currentTimeMillis());
        account.setDt_update(System.currentTimeMillis());
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(UUID uuid) {
        return accountRepository.findById(uuid)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + uuid));
    }

    @Transactional
    public Account updateAccount(UUID uuid, long dt_update, AccountCreateRequest request) {
        Account account = getAccountById(uuid);
        if (account.getDt_update() != dt_update) {
            throw new RuntimeException("Account has been updated concurrently");
        }
        account.setTitle(request.getTitle());
        account.setDescription(request.getDescription());
        account.setType(request.getType());
        account.setCurrency(request.getCurrency());
        account.setDt_update(System.currentTimeMillis());
        return accountRepository.save(account);
    }
}
package by.itacademy.userservice.service.api;

import by.itacademy.userservice.dto.AccountCreateRequest;
import by.itacademy.userservice.model.Account;

import java.util.List;
import java.util.UUID;

public interface IAccountService {
    Account createAccount(AccountCreateRequest request);
    List<Account> getAllAccounts();
    Account updateAccount(UUID uuid, long dt_update, AccountCreateRequest request);
}

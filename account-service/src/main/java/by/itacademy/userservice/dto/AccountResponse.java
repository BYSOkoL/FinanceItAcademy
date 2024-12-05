package by.itacademy.userservice.dto;

import by.itacademy.userservice.model.Account;
import lombok.Data;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class AccountResponse {

    private UUID uuid;
    private String title;
    private String description;
    private double balance;
    private String type;
    private String currency;
    private long dt_create;
    private long dt_update;

    public AccountResponse(Account account) {
        this.uuid = account.getUuid();
        this.title = account.getTitle();
        this.description = account.getDescription();
        this.balance = account.getBalance();
        this.type = account.getType();
        this.currency = account.getCurrency();
        this.dt_create = account.getDt_create();
        this.dt_update = account.getDt_update();
    }

    public static List<AccountResponse> from(List<Account> accounts) {
        return accounts.stream().map(AccountResponse::new).collect(Collectors.toList());
    }
}
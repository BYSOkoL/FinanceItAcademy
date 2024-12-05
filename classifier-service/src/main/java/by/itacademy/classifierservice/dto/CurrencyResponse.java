package by.itacademy.classifierservice.dto;

import by.itacademy.classifierservice.model.Currency;
import lombok.Data;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class CurrencyResponse {

    private UUID uuid;
    private String title;
    private String description;
    private long dt_create;
    private long dt_update;

    public CurrencyResponse(Currency currency) {
        this.uuid = currency.getUuid();
        this.title = currency.getTitle();
        this.description = currency.getDescription();
        this.dt_create = currency.getDt_create();
        this.dt_update = currency.getDt_update();
    }

    public static List<CurrencyResponse> from(List<Currency> currencies) {
        return currencies.stream().map(CurrencyResponse::new).collect(Collectors.toList());
    }
}
package by.itacademy.classifierservice.service.api;

import by.itacademy.classifierservice.dto.CurrencyCreateRequest;
import by.itacademy.classifierservice.model.Currency;

import java.util.List;
import java.util.UUID;

public interface ICurrencyService {
    Currency createCurrency(CurrencyCreateRequest request);
    List<Currency> getAllCurrencies();
    Currency getCurrencyById(UUID uuid);
    Currency updateCurrency(UUID uuid, CurrencyCreateRequest request);
}

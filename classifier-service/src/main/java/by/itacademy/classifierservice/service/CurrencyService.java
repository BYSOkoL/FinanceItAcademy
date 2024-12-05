package by.itacademy.classifierservice.service;

import by.itacademy.classifierservice.dto.CurrencyCreateRequest;
import by.itacademy.classifierservice.exception.CurrencyNotFoundException;
import by.itacademy.classifierservice.model.Currency;
import by.itacademy.classifierservice.repository.CurrencyRepository;
import by.itacademy.classifierservice.service.api.ICurrencyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CurrencyService implements ICurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Transactional
    public Currency createCurrency(CurrencyCreateRequest request) {
        Currency currency = new Currency();
        currency.setTitle(request.getTitle());
        currency.setDescription(request.getDescription());
        currency.setDt_create(System.currentTimeMillis());
        currency.setDt_update(System.currentTimeMillis());
        return currencyRepository.save(currency);
    }

    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    public Currency getCurrencyById(UUID uuid) {
        return currencyRepository.findById(uuid)
                .orElseThrow(() -> new CurrencyNotFoundException("Currency not found with id: " + uuid));
    }

    @Transactional
    public Currency updateCurrency(UUID uuid, CurrencyCreateRequest request) {
        Currency currency = getCurrencyById(uuid);
        currency.setTitle(request.getTitle());
        currency.setDescription(request.getDescription());
        currency.setDt_update(System.currentTimeMillis());
        return currencyRepository.save(currency);
    }
}
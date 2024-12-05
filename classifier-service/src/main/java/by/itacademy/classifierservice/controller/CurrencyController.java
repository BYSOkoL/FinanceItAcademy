package by.itacademy.classifierservice.controller;

import by.itacademy.classifierservice.dto.CurrencyCreateRequest;
import by.itacademy.classifierservice.dto.CurrencyResponse;
import by.itacademy.classifierservice.model.Currency;
import by.itacademy.classifierservice.service.CurrencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/classifier/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @PostMapping
    public ResponseEntity<CurrencyResponse> createCurrency(@Valid @RequestBody CurrencyCreateRequest currencyCreateRequest) {
        Currency currency = currencyService.createCurrency(currencyCreateRequest);
        return ResponseEntity.status(201).body(new CurrencyResponse(currency));
    }

    @GetMapping
    public ResponseEntity<List<CurrencyResponse>> getAllCurrencies() {
        List<Currency> currencies = currencyService.getAllCurrencies();
        return ResponseEntity.ok(CurrencyResponse.from(currencies));
    }
}
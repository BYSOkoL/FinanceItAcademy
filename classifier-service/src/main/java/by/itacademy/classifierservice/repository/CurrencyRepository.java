package by.itacademy.classifierservice.repository;

import by.itacademy.classifierservice.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CurrencyRepository extends JpaRepository<Currency, UUID> {
}
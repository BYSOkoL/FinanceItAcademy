package by.itacademy.classifierservice.repository;

import by.itacademy.classifierservice.model.OperationCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OperationCategoryRepository extends JpaRepository<OperationCategory, UUID> {
}
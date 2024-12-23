package by.itacademy.userservice.repository;

import by.itacademy.userservice.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OperationRepository extends JpaRepository<Operation, UUID> {
    List<Operation> findByAccountUuid(UUID accountId);
}
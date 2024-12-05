package by.itacademy.auditservice.repository;

import by.itacademy.auditservice.model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuditRepository extends JpaRepository<Audit, UUID> {
}
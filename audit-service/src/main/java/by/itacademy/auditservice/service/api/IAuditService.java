package by.itacademy.auditservice.service.api;

import by.itacademy.auditservice.dto.AuditCreateRequest;
import by.itacademy.auditservice.model.Audit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IAuditService {
    Audit createAudit(AuditCreateRequest request);
    Page<Audit> getAllAudits(Pageable pageable);
    Audit getAuditById(UUID uuid);
}

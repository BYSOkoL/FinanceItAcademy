package by.itacademy.auditservice.service;

import by.itacademy.auditservice.dto.AuditCreateRequest;
import by.itacademy.auditservice.exception.AuditNotFoundException;
import by.itacademy.auditservice.model.Audit;
import by.itacademy.auditservice.repository.AuditRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AuditService {

    private final AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Transactional
    public Audit createAudit(AuditCreateRequest request) {
        Audit audit = new Audit();
        audit.setUser(request.getUser());
        audit.setText(request.getText());
        audit.setType(request.getType());
        audit.setId(request.getId());
        audit.setDt_create(System.currentTimeMillis());
        audit.setDt_update(System.currentTimeMillis());
        return auditRepository.save(audit);
    }

    public Page<Audit> getAllAudits(Pageable pageable) {
        return auditRepository.findAll(pageable);
    }

    public Audit getAuditById(UUID uuid) {
        return auditRepository.findById(uuid)
                .orElseThrow(() -> new AuditNotFoundException("Audit not found with id: " + uuid));
    }
}
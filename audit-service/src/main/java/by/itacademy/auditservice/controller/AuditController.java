package by.itacademy.auditservice.controller;

import by.itacademy.auditservice.dto.AuditCreateRequest;
import by.itacademy.auditservice.dto.AuditResponse;
import by.itacademy.auditservice.dto.PageResponse;
import by.itacademy.auditservice.model.Audit;
import by.itacademy.auditservice.service.AuditService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/audit")
public class AuditController {

    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @PostMapping
    public ResponseEntity<AuditResponse> createAudit(@Valid @RequestBody AuditCreateRequest auditCreateRequest) {
        Audit audit = auditService.createAudit(auditCreateRequest);
        return ResponseEntity.status(201).body(new AuditResponse(audit));
    }

    @GetMapping
    public ResponseEntity<PageResponse<AuditResponse>> getAllAudits(Pageable pageable) {
        Page<Audit> audits = auditService.getAllAudits(pageable);
        return ResponseEntity.ok(PageResponse.from(audits.map(AuditResponse::new)));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<AuditResponse> getAuditById(@PathVariable UUID uuid) {
        Audit audit = auditService.getAuditById(uuid);
        return ResponseEntity.ok(new AuditResponse(audit));
    }
}
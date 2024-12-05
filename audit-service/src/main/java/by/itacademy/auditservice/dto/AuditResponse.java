package by.itacademy.auditservice.dto;

import by.itacademy.auditservice.model.Audit;
import lombok.Data;

import java.util.UUID;

@Data
public class AuditResponse {

    private UUID uuid;
    private String user;
    private String text;
    private String type;
    private String id;
    private long dt_create;
    private long dt_update;

    public AuditResponse(Audit audit) {
        this.uuid = audit.getUuid();
        this.user = audit.getUser();
        this.text = audit.getText();
        this.type = audit.getType();
        this.id = audit.getId();
        this.dt_create = audit.getDt_create();
        this.dt_update = audit.getDt_update();
    }
}
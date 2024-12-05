package by.itacademy.auditservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AuditCreateRequest {

    @NotBlank
    private String user;

    @NotBlank
    private String text;

    @NotBlank
    private String type;

    @NotNull
    private String id;
}
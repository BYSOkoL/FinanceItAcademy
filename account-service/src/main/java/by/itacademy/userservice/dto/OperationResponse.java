package by.itacademy.userservice.dto;

import by.itacademy.userservice.model.Operation;
import lombok.Data;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class OperationResponse {

    private UUID uuid;
    private long date;
    private String description;
    private String category;
    private double value;
    private String currency;
    private long dt_create;
    private long dt_update;

    public OperationResponse(Operation operation) {
        this.uuid = operation.getUuid();
        this.date = operation.getDate();
        this.description = operation.getDescription();
        this.category = operation.getCategory();
        this.value = operation.getValue();
        this.currency = operation.getCurrency();
        this.dt_create = operation.getDt_create();
        this.dt_update = operation.getDt_update();
    }

    public static List<OperationResponse> from(List<Operation> operations) {
        return operations.stream().map(OperationResponse::new).collect(Collectors.toList());
    }
}
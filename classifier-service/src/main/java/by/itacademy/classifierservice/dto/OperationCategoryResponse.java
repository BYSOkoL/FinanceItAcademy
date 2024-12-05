package by.itacademy.classifierservice.dto;

import by.itacademy.classifierservice.model.OperationCategory;
import lombok.Data;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class OperationCategoryResponse {

    private UUID uuid;
    private String title;
    private long dt_create;
    private long dt_update;

    public OperationCategoryResponse(OperationCategory operationCategory) {
        this.uuid = operationCategory.getUuid();
        this.title = operationCategory.getTitle();
        this.dt_create = operationCategory.getDt_create();
        this.dt_update = operationCategory.getDt_update();
    }

    public static List<OperationCategoryResponse> from(List<OperationCategory> operationCategories) {
        return operationCategories.stream().map(OperationCategoryResponse::new).collect(Collectors.toList());
    }
}
package by.itacademy.classifierservice.service.api;

import by.itacademy.classifierservice.dto.OperationCategoryCreateRequest;
import by.itacademy.classifierservice.model.OperationCategory;

import java.util.List;
import java.util.UUID;

public interface IOperationCategoryService {
    OperationCategory createOperationCategory(OperationCategoryCreateRequest request);
    List<OperationCategory> getAllOperationCategories();
    OperationCategory getOperationCategoryById(UUID uuid);
    OperationCategory updateOperationCategory(UUID uuid, OperationCategoryCreateRequest request);
}

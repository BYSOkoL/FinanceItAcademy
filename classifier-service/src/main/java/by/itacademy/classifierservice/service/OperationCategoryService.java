package by.itacademy.classifierservice.service;

import by.itacademy.classifierservice.dto.OperationCategoryCreateRequest;
import by.itacademy.classifierservice.exception.OperationCategoryNotFoundException;
import by.itacademy.classifierservice.model.OperationCategory;
import by.itacademy.classifierservice.repository.OperationCategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class OperationCategoryService {

    private final OperationCategoryRepository operationCategoryRepository;

    public OperationCategoryService(OperationCategoryRepository operationCategoryRepository) {
        this.operationCategoryRepository = operationCategoryRepository;
    }

    @Transactional
    public OperationCategory createOperationCategory(OperationCategoryCreateRequest request) {
        OperationCategory operationCategory = new OperationCategory();
        operationCategory.setTitle(request.getTitle());
        operationCategory.setDt_create(System.currentTimeMillis());
        operationCategory.setDt_update(System.currentTimeMillis());
        return operationCategoryRepository.save(operationCategory);
    }

    public List<OperationCategory> getAllOperationCategories() {
        return operationCategoryRepository.findAll();
    }

    public OperationCategory getOperationCategoryById(UUID uuid) {
        return operationCategoryRepository.findById(uuid)
                .orElseThrow(() -> new OperationCategoryNotFoundException("Operation category not found with id: " + uuid));
    }

    @Transactional
    public OperationCategory updateOperationCategory(UUID uuid, OperationCategoryCreateRequest request) {
        OperationCategory operationCategory = getOperationCategoryById(uuid);
        operationCategory.setTitle(request.getTitle());
        operationCategory.setDt_update(System.currentTimeMillis());
        return operationCategoryRepository.save(operationCategory);
    }
}
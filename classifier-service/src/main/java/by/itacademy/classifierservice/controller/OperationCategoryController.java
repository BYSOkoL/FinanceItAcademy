package by.itacademy.classifierservice.controller;

import by.itacademy.classifierservice.dto.OperationCategoryCreateRequest;
import by.itacademy.classifierservice.dto.OperationCategoryResponse;
import by.itacademy.classifierservice.model.OperationCategory;
import by.itacademy.classifierservice.service.OperationCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/classifier/operation/category")
public class OperationCategoryController {

    private final OperationCategoryService operationCategoryService;

    public OperationCategoryController(OperationCategoryService operationCategoryService) {
        this.operationCategoryService = operationCategoryService;
    }

    @PostMapping
    public ResponseEntity<OperationCategoryResponse> createOperationCategory(@Valid @RequestBody OperationCategoryCreateRequest operationCategoryCreateRequest) {
        OperationCategory operationCategory = operationCategoryService.createOperationCategory(operationCategoryCreateRequest);
        return ResponseEntity.status(201).body(new OperationCategoryResponse(operationCategory));
    }

    @GetMapping
    public ResponseEntity<List<OperationCategoryResponse>> getAllOperationCategories() {
        List<OperationCategory> operationCategories = operationCategoryService.getAllOperationCategories();
        return ResponseEntity.ok(OperationCategoryResponse.from(operationCategories));
    }
}
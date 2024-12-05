package by.itacademy.userservice.controller;

import by.itacademy.userservice.dto.OperationCreateRequest;
import by.itacademy.userservice.dto.OperationResponse;
import by.itacademy.userservice.model.Operation;
import by.itacademy.userservice.service.OperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/account/{accountId}/operation")
public class OperationController {

    private final OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @PostMapping
    public ResponseEntity<OperationResponse> createOperation(@PathVariable UUID accountId, @Valid @RequestBody OperationCreateRequest operationCreateRequest) {
        Operation operation = operationService.createOperation(accountId, operationCreateRequest);
        return ResponseEntity.status(201).body(new OperationResponse(operation));
    }

    @GetMapping
    public ResponseEntity<List<OperationResponse>> getOperationsByAccountId(@PathVariable UUID accountId) {
        List<Operation> operations = operationService.getOperationsByAccountId(accountId);
        return ResponseEntity.ok(OperationResponse.from(operations));
    }

    @PutMapping("/{operationId}/dt_update/{dt_update}")
    public ResponseEntity<OperationResponse> updateOperation(@PathVariable UUID accountId, @PathVariable UUID operationId, @PathVariable long dt_update, @Valid @RequestBody OperationCreateRequest operationCreateRequest) {
        Operation operation = operationService.updateOperation(accountId, operationId, dt_update, operationCreateRequest);
        return ResponseEntity.ok(new OperationResponse(operation));
    }

    @DeleteMapping("/{operationId}/dt_update/{dt_update}")
    public ResponseEntity<Void> deleteOperation(@PathVariable UUID accountId, @PathVariable UUID operationId, @PathVariable long dt_update) {
        operationService.deleteOperation(accountId, operationId, dt_update);
        return ResponseEntity.ok().build();
    }
}
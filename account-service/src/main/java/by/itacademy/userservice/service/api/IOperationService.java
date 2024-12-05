package by.itacademy.userservice.service.api;

import by.itacademy.userservice.dto.OperationCreateRequest;
import by.itacademy.userservice.model.Operation;

import java.util.List;
import java.util.UUID;

public interface IOperationService {
    Operation createOperation(UUID accountId, OperationCreateRequest request);
    List<Operation> getOperationsByAccountId(UUID accountId);
    void deleteOperation(UUID accountId, UUID operationId, long dt_update);
    Operation getOperationById(UUID operationId);
}

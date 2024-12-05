package by.itacademy.userservice.service;

import by.itacademy.userservice.dto.OperationCreateRequest;
import by.itacademy.userservice.exception.OperationNotFoundException;
import by.itacademy.userservice.model.Account;
import by.itacademy.userservice.model.Operation;
import by.itacademy.userservice.repository.OperationRepository;
import by.itacademy.userservice.service.api.IOperationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class OperationService implements IOperationService {

    private final OperationRepository operationRepository;
    private final AccountService accountService;

    public OperationService(OperationRepository operationRepository, AccountService accountService) {
        this.operationRepository = operationRepository;
        this.accountService = accountService;
    }

    @Transactional
    public Operation createOperation(UUID accountId, OperationCreateRequest request) {
        Account account = accountService.getAccountById(accountId);
        Operation operation = new Operation();
        operation.setAccount(account);
        operation.setDate(request.getDate());
        operation.setDescription(request.getDescription());
        operation.setCategory(request.getCategory());
        operation.setValue(request.getValue());
        operation.setCurrency(request.getCurrency());
        operation.setDt_create(System.currentTimeMillis());
        operation.setDt_update(System.currentTimeMillis());
        return operationRepository.save(operation);
    }

    public List<Operation> getOperationsByAccountId(UUID accountId) {
        return operationRepository.findByAccountUuid(accountId);
    }

    @Transactional
    public Operation updateOperation(UUID accountId, UUID operationId, long dt_update, OperationCreateRequest request) {
        Operation operation = getOperationById(operationId);
        if (operation.getDt_update() != dt_update) {
            throw new RuntimeException("Operation has been updated concurrently");
        }
        operation.setDate(request.getDate());
        operation.setDescription(request.getDescription());
        operation.setCategory(request.getCategory());
        operation.setValue(request.getValue());
        operation.setCurrency(request.getCurrency());
        operation.setDt_update(System.currentTimeMillis());
        return operationRepository.save(operation);
    }

    @Transactional
    public void deleteOperation(UUID accountId, UUID operationId, long dt_update) {
        Operation operation = getOperationById(operationId);
        if (operation.getDt_update() != dt_update) {
            throw new RuntimeException("Operation has been updated concurrently");
        }
        operationRepository.delete(operation);
    }

    public Operation getOperationById(UUID operationId) {
        return operationRepository.findById(operationId)
                .orElseThrow(() -> new OperationNotFoundException("Operation not found with id: " + operationId));
    }
}
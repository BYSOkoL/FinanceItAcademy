package by.itacademy.classifierservice.exception;

public class OperationCategoryNotFoundException extends RuntimeException {
    public OperationCategoryNotFoundException(String message) {
        super(message);
    }
}
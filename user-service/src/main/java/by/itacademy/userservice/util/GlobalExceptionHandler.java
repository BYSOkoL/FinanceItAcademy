package by.itacademy.userservice.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleException(Exception ex) {
        return new ResponseEntity<>(new ErrorResponse("Internal server error", ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleBadRequest(Exception ex) {
        return new ResponseEntity<>(new ErrorResponse("Bad request", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
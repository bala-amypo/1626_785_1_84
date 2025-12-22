package com.example.demo.exception;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<String> handleVehicleNotFoundException(VehicleNotFoundException ex){
        return new ResponseEntity<String>(ex.getMessage(HttpStatus.BAD_GATEWAY));
    }
}
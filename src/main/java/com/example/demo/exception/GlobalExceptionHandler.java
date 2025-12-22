package com.example.demo.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateVinException.class)
    public ResponseEntity<String> handleDuplicateVinException(DuplicateVinException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    // @ExceptionHandler(OdometerValidationException.class)
    // public ResponseEntity<String> handleOdometerException(OdometerValidationException ex) {
    //     return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    // }

    // @ExceptionHandler(FutureServiceDateException.class)
    // public ResponseEntity<String> handleFutureDateException(FutureServiceDateException ex) {
    //     return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    // }

    // @ExceptionHandler(ImmutableRecordException.class)
    // public ResponseEntity<String> handleImmutableException(ImmutableRecordException ex) {
    //     return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
    // }
     @ExceptionHandler(GarageException.class)
    public ResponseEntity<String> handleDuplicateVinException(DuplicateVinException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}

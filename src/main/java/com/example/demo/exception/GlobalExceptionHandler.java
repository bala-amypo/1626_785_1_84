// package com.example.demo.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// import jakarta.persistence.EntityNotFoundException;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(DuplicateVinException.class)
//     public ResponseEntity<String> handleDuplicateVinException(DuplicateVinException ex) {
//         return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
//     }

//     @ExceptionHandler(EntityNotFoundException.class)
//     public ResponseEntity<String> handleNotFound(EntityNotFoundException ex) {
//         return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//     }

//     @ExceptionHandler(IllegalArgumentException.class)
//     public ResponseEntity<String> handleBadRequest(IllegalArgumentException ex) {
//         return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//     }
// @ExceptionHandler(IllegalArgumentException.class)
// public ResponseEntity<String> handleIllegal(IllegalArgumentException ex) {
//     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
// }

    
// }
package com.example.demo.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
     @ExceptionHandler(DuplicateVinException.class)
    public ResponseEntity<String> handleDuplicateVinException(DuplicateVinException ex) {
       return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegal(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleNotFound(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOtherExceptions(Exception ex) {
        return new ResponseEntity<>(
                "Internal server error",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}

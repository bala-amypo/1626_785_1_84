// package com.example.demo.exception;

// import org.springframework.web.bind.annotation.RestControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.http.ResponseEntity;
// import org.springframework.http.HttpStatus;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(DuplicateVinException.class)
//     public ResponseEntity<String> handleDuplicateVinException(DuplicateVinException ex) {
//         return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
//     }

//     // @ExceptionHandler(OdometerValidationException.class)
//     // public ResponseEntity<String> handleOdometerException(OdometerValidationException ex) {
//     //     return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//     // }

//     // @ExceptionHandler(FutureServiceDateException.class)
//     // public ResponseEntity<String> handleFutureDateException(FutureServiceDateException ex) {
//     //     return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//     // }

//     // @ExceptionHandler(ImmutableRecordException.class)
//     // public ResponseEntity<String> handleImmutableException(ImmutableRecordException ex) {
//     //     return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
//     // }
//     //  @ExceptionHandler(GarageException.class)
//     // public ResponseEntity<String> handleGarageException(GarageException ex) {
//     //     return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
//     // }

// }
package com.example.demo.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(EntityNotFoundException ex) {
        ApiError err = new ApiError(LocalDateTime.now(), 404, "NOT_FOUND", ex.getMessage());
        return new ResponseEntity<ApiError>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleBadRequest(IllegalArgumentException ex) {
        ApiError err = new ApiError(LocalDateTime.now(), 400, "BAD_REQUEST", ex.getMessage());
        return new ResponseEntity<ApiError>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handleGeneric(RuntimeException ex) {
        ApiError err = new ApiError(LocalDateTime.now(), 500, "INTERNAL_ERROR", ex.getMessage());
        return new ResponseEntity<ApiError>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static class ApiError {
        private LocalDateTime timestamp;
        private int status;
        private String error;
        private String message;

        public ApiError(LocalDateTime timestamp, int status, String error, String message) {
            this.timestamp = timestamp;
            this.status = status;
            this.error = error;
            this.message = message;
        }

        public LocalDateTime getTimestamp() { return timestamp; }
        public int getStatus() { return status; }
        public String getError() { return error; }
        public String getMessage() { return message; }
    }
}

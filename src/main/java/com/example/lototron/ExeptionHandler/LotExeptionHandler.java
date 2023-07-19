package com.example.lototron.ExeptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LotExeptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> hendleNotIdExeption(NotIdExeption notIdExeption) {
        String message = "Lot not found\n";
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<?> hendleStatusExeption(StatusExeption statusExeption) {
        String message = "Lot is not in the correct status\n";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<?> hendleDataExeption(DataExeption dataExeption) {
        String message = "Lot is not in the correct\n";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}

package com.devsu.hackerearth.backend.account.controller;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.devsu.hackerearth.backend.account.exception.AccountNotFoundException;
import com.devsu.hackerearth.backend.account.exception.BalanceNotAvailableException;
import com.devsu.hackerearth.backend.account.exception.TransactionNotFoundException;
import com.devsu.hackerearth.backend.account.model.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleAccountNotFound(AccountNotFoundException ex, WebRequest request) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(Integer.valueOf(HttpStatus.NOT_FOUND.value()),
                ex.getMessage(), request.getDescription(false), Instant.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleTransactionNotFound(TransactionNotFoundException ex,
            WebRequest request) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(Integer.valueOf(HttpStatus.NOT_FOUND.value()),
                ex.getMessage(), request.getDescription(false), Instant.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(BalanceNotAvailableException.class)
    public ResponseEntity<ErrorResponseDto> handleBalanceNotAvailable(BalanceNotAvailableException ex,
            WebRequest request) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(Integer.valueOf(HttpStatus.NOT_FOUND.value()),
                ex.getMessage(), request.getDescription(false), Instant.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGeneralExceptions(Exception ex, WebRequest request) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(Integer.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                "Internal Server Error", request.getDescription(false), Instant.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}

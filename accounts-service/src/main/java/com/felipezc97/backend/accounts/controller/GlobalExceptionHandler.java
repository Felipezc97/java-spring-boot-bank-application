package com.felipezc97.backend.accounts.controller;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.felipezc97.backend.accounts.exception.AccountNotFoundException;
import com.felipezc97.backend.accounts.exception.BalanceNotAvailableException;
import com.felipezc97.backend.accounts.exception.TransactionNotFoundException;
import com.felipezc97.backend.accounts.model.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponseDto> handleAccountNotFound(AccountNotFoundException ex, WebRequest request) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(Integer.valueOf(HttpStatus.NOT_FOUND.value()),
                ex.getMessage(), request.getDescription(false), Instant.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(TransactionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponseDto> handleTransactionNotFound(TransactionNotFoundException ex,
            WebRequest request) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(Integer.valueOf(HttpStatus.NOT_FOUND.value()),
                ex.getMessage(), request.getDescription(false), Instant.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(BalanceNotAvailableException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponseDto> handleBalanceNotAvailable(BalanceNotAvailableException ex,
            WebRequest request) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(Integer.valueOf(HttpStatus.NOT_FOUND.value()),
                ex.getMessage(), request.getDescription(false), Instant.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponseDto> handleGeneralExceptions(Exception ex, WebRequest request) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(Integer.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                "Internal Server Error", request.getDescription(false), Instant.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}

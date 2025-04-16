package com.felipezc97.backend.accounts.model.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDto {

    private Integer statusCode;
    private String message;
    private String detail;
    private Instant timestamp;
    
}

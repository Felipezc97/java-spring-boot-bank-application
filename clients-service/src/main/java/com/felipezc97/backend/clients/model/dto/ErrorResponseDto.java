package com.felipezc97.backend.clients.model.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDto {

    private Integer statuscode;
    private String message;
    private String detail;
    private Instant timestamp;

}

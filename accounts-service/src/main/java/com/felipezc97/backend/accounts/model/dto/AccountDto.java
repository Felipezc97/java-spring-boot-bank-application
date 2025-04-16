package com.felipezc97.backend.accounts.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
	private Long id;
	private String number;
	private String type;
	private double initialAmount;
	private Boolean isActive;
	private Long clientId;
}

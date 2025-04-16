package com.felipezc97.backend.clients.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDto {

	private Long id;
	private String dni;
	private String name;
	private String password;
	private String gender;
	private Integer age;
	private String address;
	private String phone;
	private Boolean isActive;
}

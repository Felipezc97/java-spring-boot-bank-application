package com.felipezc97.backend.clients.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class Person extends Base {
	
	@NotNull(message = "Name is required for the person")
	@Column(nullable = false)
	private String name;
	
	@NotNull(message = "Identification is required for the person")
	@Column(nullable = false)
	private String dni;
	
	private String gender;
	
	@Positive
	private Integer age;
	
	private String address;
	
	private String phone;
}

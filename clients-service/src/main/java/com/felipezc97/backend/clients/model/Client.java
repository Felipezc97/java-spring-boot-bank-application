package com.felipezc97.backend.clients.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client extends Person {

	@NotNull(message = "Password is required for every client")
	@Column(nullable = false)
	private String password;

	@NotNull
	@Column(name = "is_active", nullable = false, columnDefinition = "boolean default true")
	private Boolean isActive;
}

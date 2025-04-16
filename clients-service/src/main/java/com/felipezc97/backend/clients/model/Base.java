package com.felipezc97.backend.clients.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Setter;

import lombok.Getter;

@MappedSuperclass
@Getter
@Setter
public class Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}

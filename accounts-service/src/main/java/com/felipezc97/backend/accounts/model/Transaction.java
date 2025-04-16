package com.felipezc97.backend.accounts.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction extends Base {

	@NotNull(message = "Transaction date is required in the system")
	@Column(name = "tran_date", nullable = false)
	private Date date;

	@NotNull(message = "Transaction type is required in the system")
	@Column(nullable = false)
	private String type;

	@NotNull(message = "Transaction amount is required in the system")
	@Column(nullable = false, precision = 15, scale = 2)
	private double amount;

	@Column(precision = 15, scale = 2)
	private double balance;

	@NotNull(message = "Transaction must be associated with an account")
	@Column(name = "account_id")
	private Long accountId;
}

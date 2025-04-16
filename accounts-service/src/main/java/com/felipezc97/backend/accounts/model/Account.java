package com.felipezc97.backend.accounts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends Base {

    @NotNull(message = "Account number is required in the system")
    @Column(name = "account_number", nullable = false)
    private String number;

    @NotNull(message = "Account type is required in the system")
    private String type;

    @NotNull(message = "Initial amount is required for the account")
    @Column(name = "initial_amount", nullable = false, precision = 15, scale = 2)
    private double initialAmount;

    @NotNull(message = "Account status is required for the account")
    @Column(name = "is_active", nullable = false, columnDefinition = "boolean default true")
    private Boolean isActive;

    @NotNull(message = "Account must be linked with a client")
    @Column(name = "client_id", nullable = false)
    private Long clientId;
}

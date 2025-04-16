package com.felipezc97.backend.accounts.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.felipezc97.backend.accounts.model.Account;
import com.felipezc97.backend.accounts.model.Transaction;
import com.felipezc97.backend.accounts.model.dto.BankStatementDto;
import com.felipezc97.backend.accounts.model.dto.TransactionDto;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    // Map Transaction entity to DTO
    TransactionDto toDto(Transaction transaction);

    // Map Transaction entity list to DTO list
    List<TransactionDto> toDtoList(List<Transaction> transactions);

    // Map DTO to Transaction Entity
    Transaction toEntity(TransactionDto transaction);

    // Map to Bank Statement DTO
    @Mapping(target = "date", source = "transaction.date")
    @Mapping(target = "client", source = "clientName")
    @Mapping(target = "accountNumber", source = "account.number")
    @Mapping(target = "accountType", source = "account.type")
    @Mapping(target = "initialAmount", source = "account.initialAmount")
    @Mapping(target = "isActive", source = "account.isActive")
    @Mapping(target = "transactionType", source = "transaction.type")
    @Mapping(target = "amount", source = "transaction.amount")
    @Mapping(target = "balance", source = "transaction.balance")
    BankStatementDto toBankStatementDto(Transaction transaction, Account account, String clientName);
}

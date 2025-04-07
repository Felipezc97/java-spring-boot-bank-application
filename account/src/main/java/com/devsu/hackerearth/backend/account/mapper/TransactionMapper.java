package com.devsu.hackerearth.backend.account.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.devsu.hackerearth.backend.account.model.Account;
import com.devsu.hackerearth.backend.account.model.Transaction;
import com.devsu.hackerearth.backend.account.model.dto.BankStatementDto;
import com.devsu.hackerearth.backend.account.model.dto.TransactionDto;

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

package com.felipezc97.backend.accounts.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.felipezc97.backend.accounts.model.Account;
import com.felipezc97.backend.accounts.model.dto.AccountDto;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    // Map Account entity to DTO
    AccountDto toDto(Account account);

    // Map Account entity list to DTO list
    List<AccountDto> toDtoList(List<Account> accounts);

    // Map DTO to Account Entity
    Account toEntity(AccountDto account);
}

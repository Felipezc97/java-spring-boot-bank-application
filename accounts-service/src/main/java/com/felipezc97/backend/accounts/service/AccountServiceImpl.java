package com.felipezc97.backend.accounts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.felipezc97.backend.accounts.exception.AccountNotFoundException;
import com.felipezc97.backend.accounts.mapper.AccountMapper;
import com.felipezc97.backend.accounts.model.Account;
import com.felipezc97.backend.accounts.model.dto.AccountDto;
import com.felipezc97.backend.accounts.model.dto.PartialAccountDto;
import com.felipezc97.backend.accounts.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper mapper;

    @Override
    public List<AccountDto> getAll() {
        List<Account> accounts = accountRepository.findAll();
        return mapper.toDtoList(accounts);
    }

    @Override
    public AccountDto getById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with ID:" + id));
        return mapper.toDto(account);
    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        Account entity = mapper.toEntity(accountDto);
        Account createdAccount = accountRepository.save(entity);
        return mapper.toDto(createdAccount);
    }

    @Override
    public AccountDto update(AccountDto accountDto) {
        Account account = accountRepository.findById(accountDto.getId())
                .orElseThrow(() -> new AccountNotFoundException("Account not found with ID:" + accountDto.getId()));
        Account newAccountInfo = mapper.toEntity(accountDto);
        newAccountInfo.setId(account.getId());
        Account updatedAccount = accountRepository.save(newAccountInfo);
        return mapper.toDto(updatedAccount);
    }

    @Override
    public AccountDto partialUpdate(Long id, PartialAccountDto partialAccountDto) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with ID:" + id));
        account.setIsActive(partialAccountDto.getIsActive());
        Account updatedAccount = accountRepository.save(account);
        return mapper.toDto(updatedAccount);
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

}

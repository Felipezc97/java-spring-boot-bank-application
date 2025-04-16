package com.felipezc97.backend.accounts.service;

import java.util.List;

import com.felipezc97.backend.accounts.model.dto.AccountDto;
import com.felipezc97.backend.accounts.model.dto.PartialAccountDto;

public interface AccountService {

    public List<AccountDto> getAll();
	public AccountDto getById(Long id);
	public AccountDto create(AccountDto accountDto);
	public AccountDto update(AccountDto accountDto);
	public AccountDto partialUpdate(Long id, PartialAccountDto partialAccountDto);
	public void deleteById(Long id);
}

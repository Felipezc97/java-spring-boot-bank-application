package com.felipezc97.backend.accounts.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipezc97.backend.accounts.model.dto.AccountDto;
import com.felipezc97.backend.accounts.model.dto.PartialAccountDto;
import com.felipezc97.backend.accounts.service.AccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	private final AccountService accountService;

	@GetMapping
	public ResponseEntity<List<AccountDto>> getAll() {
		List<AccountDto> accounts = accountService.getAll();
		return ResponseEntity.ok(accounts);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> get(@PathVariable Long id) {
		AccountDto account = accountService.getById(id);
		return ResponseEntity.ok(account);
	}

	@PostMapping
	public ResponseEntity<AccountDto> create(@RequestBody AccountDto accountDto) {
		AccountDto account = accountService.create(accountDto);
		return ResponseEntity.created(URI.create("accounts/" + account.getId())).body(account);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AccountDto> update(@PathVariable Long id, @RequestBody AccountDto accountDto) {
		AccountDto account = accountService.update(accountDto);
		return ResponseEntity.ok(account);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<AccountDto> partialUpdate(@PathVariable Long id,
			@RequestBody PartialAccountDto partialAccountDto) {
		AccountDto account = accountService.partialUpdate(id, partialAccountDto);
		return ResponseEntity.ok(account);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		accountService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}

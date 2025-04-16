package com.felipezc97.backend.accounts.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipezc97.backend.accounts.model.dto.BankStatementDto;
import com.felipezc97.backend.accounts.model.dto.TransactionDto;
import com.felipezc97.backend.accounts.service.TransactionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    
    private final TransactionService transactionService;

	@GetMapping
    public ResponseEntity<List<TransactionDto>> getAll(){
		List<TransactionDto> transactions = transactionService.getAll();
		return ResponseEntity.ok(transactions);
	}

	@GetMapping("/{id}")
    public ResponseEntity<TransactionDto> get(@PathVariable Long id){
		TransactionDto transaction = transactionService.getById(id);
		return ResponseEntity.ok(transaction);
	}

	@PostMapping
	public ResponseEntity<TransactionDto> create(@RequestBody TransactionDto transactionDto){
		TransactionDto transaction = transactionService.create(transactionDto);
		return ResponseEntity.created(URI.create("transactions/" + transaction.getId())).body(transaction);
	}

	@GetMapping("/clients/{clientId}/report")
    public ResponseEntity<List<BankStatementDto>> report(@PathVariable Long clientId, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTransactionStart, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTransactionEnd) {
		List<BankStatementDto> bankStatementDetails = transactionService.getAllByAccountClientIdAndDateBetween(clientId, dateTransactionStart, dateTransactionEnd);
		return ResponseEntity.ok(bankStatementDetails);
	}
}

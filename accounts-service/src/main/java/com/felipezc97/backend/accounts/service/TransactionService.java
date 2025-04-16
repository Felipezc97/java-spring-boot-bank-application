package com.felipezc97.backend.accounts.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.felipezc97.backend.accounts.model.dto.BankStatementDto;
import com.felipezc97.backend.accounts.model.dto.TransactionDto;

public interface TransactionService {

    public List<TransactionDto> getAll();
	public TransactionDto getById(Long id);
	public TransactionDto create(TransactionDto transactionDto);
    public List<BankStatementDto> getAllByAccountClientIdAndDateBetween(Long clientId, @Param("dateTransactionStart") Date dateTransactionStart, @Param("dateTransactionEnd") Date dateTransactionEnd);
}

package com.felipezc97.backend.accounts.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.felipezc97.backend.accounts.exception.AccountNotFoundException;
import com.felipezc97.backend.accounts.exception.BalanceNotAvailableException;
import com.felipezc97.backend.accounts.exception.TransactionNotFoundException;
import com.felipezc97.backend.accounts.mapper.TransactionMapper;
import com.felipezc97.backend.accounts.model.Account;
import com.felipezc97.backend.accounts.model.Transaction;
import com.felipezc97.backend.accounts.model.dto.BankStatementDto;
import com.felipezc97.backend.accounts.model.dto.TransactionDto;
import com.felipezc97.backend.accounts.repository.AccountRepository;
import com.felipezc97.backend.accounts.repository.TransactionRepository;
import com.felipezc97.backend.accounts.utils.TransactionUtils;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final WebClient webClient;
    private final TransactionMapper mapper;

    private final String getClientInformationUrl = "/api/clients/";

    @Override
    public List<TransactionDto> getAll() {
        List<Transaction> transactions = transactionRepository.findAll();
        return mapper.toDtoList(transactions);
    }

    @Override
    public TransactionDto getById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found with ID:" + id));
        return mapper.toDto(transaction);
    }

    @Override
    public TransactionDto create(TransactionDto transactionDto) {
        Transaction entity = mapper.toEntity(transactionDto);
        // Get all transactions list
        Long accountId = transactionDto.getAccountId();
        List<Transaction> transactions = transactionRepository.getTransactionsByAccount(accountId);
        // Initialize new balance value
        double targetBalance = 0.0;
        // Validation to start balance calculation
        if (transactions.isEmpty()) {
            // Get information of the account to get intial amount
            Account currentAccount = accountRepository.findById(accountId)
                    .orElseThrow(() -> new AccountNotFoundException("Account not found with ID:" + accountId));
            targetBalance = currentAccount.getInitialAmount() + transactionDto.getAmount();
        } else {
            // Get last transaction information
            Transaction lastTransaction = TransactionUtils.findLastTransactionForAccount(transactions)
                    .orElseThrow(() -> new TransactionNotFoundException("Transaction not found for the account"));
            targetBalance = lastTransaction.getBalance() + transactionDto.getAmount();
        }
        // Validate the viability of the transaction
        if (targetBalance >= 0.0) {
            entity.setBalance(targetBalance);
        } else {
            throw new BalanceNotAvailableException("Balance not available for this transaction");
        }
        Transaction createdTransaction = transactionRepository.save(entity);
        return mapper.toDto(createdTransaction);
    }

    @Override
    public List<BankStatementDto> getAllByAccountClientIdAndDateBetween(Long clientId, Date dateTransactionStart,
            Date dateTransactionEnd) {
        // Initialize response object
        List<BankStatementDto> response = new ArrayList<>();

        // Get client information
        String clientName = getClientName(clientId);

        // Get all accounts for the client
        List<Account> accounts = accountRepository.findAccountsByClient(clientId);
        
        // Navigate through all accounts to get transaction information
        for (Account account : accounts) {   
            // Get all transactions for each account
            List<Transaction> transactions = transactionRepository.getTransactionsByAccountInDateRange(account.getId(), dateTransactionStart, dateTransactionEnd);
            List<BankStatementDto> transactionsInfoList = transactions.stream().map(trans -> mapper.toBankStatementDto(trans, account, clientName)).collect(Collectors.toList());
            response.addAll(transactionsInfoList);
        }
        return response;
    }

    private String getClientName(Long clientId) {
        return webClient.get().uri(getClientInformationUrl + clientId).retrieve().bodyToMono(JsonNode.class).block().get("name").asText();
    }

}

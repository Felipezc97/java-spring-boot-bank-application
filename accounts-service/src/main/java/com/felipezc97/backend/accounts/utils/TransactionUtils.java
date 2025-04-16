package com.felipezc97.backend.accounts.utils;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.felipezc97.backend.accounts.model.Transaction;

public class TransactionUtils {

    public static Optional<Transaction> findLastTransactionForAccount(List<Transaction> transactions) {
        return transactions.stream().max(Comparator.comparingLong(Transaction::getAccountId));
    }
    
}

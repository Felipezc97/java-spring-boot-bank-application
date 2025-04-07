package com.devsu.hackerearth.backend.account.utils;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.devsu.hackerearth.backend.account.model.Transaction;

public class TransactionUtils {

    public static Optional<Transaction> findLastTransactionForAccount(List<Transaction> transactions) {
        return transactions.stream().max(Comparator.comparingLong(Transaction::getAccountId));
    }
    
}

package com.felipezc97.backend.accounts.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.felipezc97.backend.accounts.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE t.accountId = :accountId")
    List<Transaction> getTransactionsByAccount(@Param("accountId") Long accountId);

    @Query("SELECT t FROM Transaction t WHERE t.accountId = :accountId AND t.date >= :initDate AND t.date<= :endDate")
    List<Transaction> getTransactionsByAccountInDateRange(@Param("accountId") Long accountId, @Param("initDate") Date initDate, @Param("endDate") Date endDate);

}

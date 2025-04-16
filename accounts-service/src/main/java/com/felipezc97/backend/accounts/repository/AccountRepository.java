package com.felipezc97.backend.accounts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.felipezc97.backend.accounts.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a WHERE a.clientId = :clientId")
    List<Account> findAccountsByClient(@Param("clientId") Long clientId);

}

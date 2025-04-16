package com.felipezc97.backend.clients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipezc97.backend.clients.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}

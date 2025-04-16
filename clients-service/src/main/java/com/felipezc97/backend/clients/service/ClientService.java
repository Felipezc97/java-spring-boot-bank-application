package com.felipezc97.backend.clients.service;

import java.util.List;

import com.felipezc97.backend.clients.model.dto.ClientDto;
import com.felipezc97.backend.clients.model.dto.PartialClientDto;

public interface ClientService {

	public List<ClientDto> getAll();
	public ClientDto getById(Long id);
	public ClientDto create(ClientDto clientDto);
	public ClientDto update(ClientDto clientDto);
	public ClientDto partialUpdate(Long id, PartialClientDto partialClientDto);
	public void deleteById(Long id);
}

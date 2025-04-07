package com.devsu.hackerearth.backend.client.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsu.hackerearth.backend.client.exception.ClientNotFoundException;
import com.devsu.hackerearth.backend.client.mapper.ClientMapper;
import com.devsu.hackerearth.backend.client.model.Client;
import com.devsu.hackerearth.backend.client.model.dto.ClientDto;
import com.devsu.hackerearth.backend.client.model.dto.PartialClientDto;
import com.devsu.hackerearth.backend.client.repository.ClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

	private final ClientRepository clientRepository;
	private final ClientMapper mapper;

	@Override
	public List<ClientDto> getAll() {
		List<Client> clients = clientRepository.findAll();
		return mapper.toDtoList(clients);
	}

	@Override
	public ClientDto getById(Long id) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new ClientNotFoundException("Client not found with ID: " + id));
		return mapper.toDto(client);
	}

	@Override
	public ClientDto create(ClientDto clientDto) {
		Client entity = mapper.toEntity(clientDto);
		Client createdClient = clientRepository.save(entity);
		return mapper.toDto(createdClient);
	}

	@Override
	public ClientDto update(ClientDto clientDto) {
		Client client = clientRepository.findById(clientDto.getId())
				.orElseThrow(() -> new ClientNotFoundException("Client not found with ID: " + clientDto.getId()));
		Client newClientInfo = mapper.toEntity(clientDto);
		newClientInfo.setId(client.getId());
		Client updateClient = clientRepository.save(newClientInfo);
		return mapper.toDto(updateClient);
	}

	@Override
	public ClientDto partialUpdate(Long id, PartialClientDto partialClientDto) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new ClientNotFoundException("Client not found with ID: " + id));
		client.setIsActive(partialClientDto.getIsActive());
		Client updatedClient = clientRepository.save(client);
		return mapper.toDto(updatedClient);
	}

	@Override
	public void deleteById(Long id) {
		clientRepository.findById(id)
				.orElseThrow(() -> new ClientNotFoundException("Client not found with ID: " + id));
		clientRepository.deleteById(id);
	}
}

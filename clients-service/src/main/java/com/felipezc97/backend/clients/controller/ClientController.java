package com.felipezc97.backend.clients.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipezc97.backend.clients.model.dto.ClientDto;
import com.felipezc97.backend.clients.model.dto.PartialClientDto;
import com.felipezc97.backend.clients.service.ClientService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/clients")
public class ClientController {

	private final ClientService clientService;

	@GetMapping
	public ResponseEntity<List<ClientDto>> getAll() {
		List<ClientDto> clients = clientService.getAll();
		return ResponseEntity.ok(clients);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClientDto> get(@PathVariable Long id) {
		ClientDto client = clientService.getById(id);
		return ResponseEntity.ok(client);		
	}

	@PostMapping
	public ResponseEntity<ClientDto> create(@RequestBody ClientDto clientDto) {
		ClientDto client = clientService.create(clientDto);
		return ResponseEntity.created(URI.create("clients/" + client.getId())).body(client);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClientDto> update(@PathVariable Long id, @RequestBody ClientDto clientDto) {
		ClientDto client = clientService.update(clientDto);
		return ResponseEntity.ok(client);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ClientDto> partialUpdate(@PathVariable Long id,
			@RequestBody PartialClientDto partialClientDto) {
		ClientDto client = clientService.partialUpdate(id, partialClientDto);
		return ResponseEntity.ok(client);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clientService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}

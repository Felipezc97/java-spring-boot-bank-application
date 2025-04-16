package com.felipezc97.backend.clients.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.felipezc97.backend.clients.model.Client;
import com.felipezc97.backend.clients.model.dto.ClientDto;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    // Map Client entity to DTO
    ClientDto toDto(Client client);

    // Map Client entity list to DTO list
    List<ClientDto> toDtoList(List<Client> clients);

    // Map DTO to Client entity
    Client toEntity(ClientDto client);
    
}

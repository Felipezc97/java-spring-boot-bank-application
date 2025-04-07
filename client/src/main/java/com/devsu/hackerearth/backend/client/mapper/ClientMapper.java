package com.devsu.hackerearth.backend.client.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.devsu.hackerearth.backend.client.model.Client;
import com.devsu.hackerearth.backend.client.model.dto.ClientDto;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    // Map Client entity to DTO
    ClientDto toDto(Client client);

    // Map Client entity list to DTO list
    List<ClientDto> toDtoList(List<Client> clients);

    // Map DTO to Client entity
    Client toEntity(ClientDto client);
    
}

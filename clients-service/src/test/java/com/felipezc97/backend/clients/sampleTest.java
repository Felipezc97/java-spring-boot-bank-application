package com.felipezc97.backend.clients;

import com.felipezc97.backend.clients.controller.ClientController;
import com.felipezc97.backend.clients.model.dto.ClientDto;
import com.felipezc97.backend.clients.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RequiredArgsConstructor
@SpringBootTest
public class sampleTest {

    private ClientService clientService = mock(ClientService.class);
    private ClientController clientController = new ClientController(clientService);

    @Test
    void createClientTest() {
        // Arrange
        ClientDto newClient = new ClientDto(1L, "Dni", "Name", "Password", "Gender", 1, "Address", "9999999999", true);
        ClientDto createdClient = new ClientDto(1L, "Dni", "Name", "Password", "Gender", 1, "Address", "9999999999",
                true);
        when(clientService.create(newClient)).thenReturn(createdClient);

        // Act
        ResponseEntity<ClientDto> response = clientController.create(newClient);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdClient, response.getBody());
    }

    // FZU: unit test
    @Test
    void getClientByIdTest() {

        // Arrange
        ClientDto consultedClient = new ClientDto(1L, "Dni", "Name", "Password", "Gender", 1, "Address", "9999999999",
                true);
        when(clientService.getById(1L)).thenReturn(consultedClient);

        // Act and assert in success case
        ResponseEntity<ClientDto> response = clientController.get(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(consultedClient, response.getBody());

        // Act antd assert in failure case
        response = clientController.get(2L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}

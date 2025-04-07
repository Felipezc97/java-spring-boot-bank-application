package com.devsu.hackerearth.backend.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.devsu.hackerearth.backend.client.controller.ClientController;
import com.devsu.hackerearth.backend.client.model.dto.ClientDto;
import com.devsu.hackerearth.backend.client.service.ClientService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootTest
@AutoConfigureMockMvc
public class sampleTest {

    @Autowired
    private final MockMvc mockMvc;

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

        // Arragnge
        ClientDto consultedClient = new ClientDto(1L, "Dni", "Name", "Password", "Gender", 1, "Address", "9999999999",
                true);
        when(clientService.getById(anyLong())).thenReturn(consultedClient);

        // Act and assert in success case
        ResponseEntity<ClientDto> response = clientController.get(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(consultedClient, response.getBody());

        // Act antd assert in failure case
        response = clientController.get(2L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // FZU: integration test
    /* @Test
    void getClientTest() throws Exception {
        // Arrange
        Long clientId = 1L;

        // Act and assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/clients/" + clientId).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(clientId));
    } */

}

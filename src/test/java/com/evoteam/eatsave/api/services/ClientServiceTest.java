package com.evoteam.eatsave.api.services;

import com.evoteam.eatsave.api.domain.models.Client;
import com.evoteam.eatsave.api.domain.models.User;
import com.evoteam.eatsave.api.domain.persistence.ClientRepository;
import com.evoteam.eatsave.api.services.implementations.ClientServiceImpl;
import com.evoteam.eatsave.api.services.interfaces.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


import static org.mockito.Mockito.when;

class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;
    @InjectMocks
    private ClientServiceImpl clientService;
    private User user;
    private Client client;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User(null, "Favio", "Viera", "test12", "abcde", new ArrayList<>());
        client = new Client(null, "megapollo", new ArrayList<>(), user);
    }
    @Test
    void createClient() {
        when(clientRepository.save(Mockito.any(Client.class))).thenReturn(client);
        Client createdClient = clientService.createClient(client);
        assertNotNull(createdClient);
        assertEquals(createdClient.getUser().getUsername(), "test12");
    }
}
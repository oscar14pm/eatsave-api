package com.evoteam.eatsave.cucumber.steps;

import com.evoteam.eatsave.api.domain.models.Client;
import com.evoteam.eatsave.api.domain.persistence.ClientRepository;
import com.evoteam.eatsave.api.services.implementations.ClientServiceImpl;
import com.evoteam.eatsave.api.services.implementations.UserServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientRegistration {
    @Autowired
    private ClientServiceImpl clientService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ClientRepository clientRepository;
    private List<Map<String, String>> expectedClients;
    private List<Client> actualClients;
    @BeforeEach
    public void setUp() {
        expectedClients = new ArrayList<>();
        actualClients = new ArrayList<>();
        clientRepository.deleteAll();
    }
    @Given("^the following clients")
    public void givenTheFollowingClients(final List<Map<String,String>> clients) {
        expectedClients = clients;
    }
    @When("^the clients register theirs accounts")
    public void whenTheClientsRegisterTheirAccounts() {
        actualClients = new ArrayList<>();
        expectedClients.forEach(client -> {
            actualClients.add(clientService.buildClient(client));
        });
    }
    @Then("^all the users are created successfully")
    public void allTheUsersAreCreatedSuccessfully() {
        for (Client actualClient : actualClients) {
            validateUsernames(actualClient.getUser().getUsername());
        }
    }
    private void validateUsernames(String username) {
        Assertions.assertNotNull(userService.getUser(username));
    }

}

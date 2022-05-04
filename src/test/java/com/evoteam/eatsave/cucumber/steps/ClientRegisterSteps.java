package com.evoteam.eatsave.cucumber.steps;

import com.evoteam.eatsave.api.domain.models.Client;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

public class ClientRegisterSteps {
    @BeforeEach
    public void setUp() {

    }
    @Given("^the following clients")
    public void givenTheFollowingClients(final List<Client> clients) {
        System.out.println(clients);
    }
    @When("^the client calls /")
    public void theClientIssuesRootPage() throws Throwable {

    }
    @Then("^the client receives status code of 200")
    public void theClientReceivesOK() throws Throwable {
    }
    @And("^the client receives greet message (.+)$")
    public void theClientReceivesGreet(String greet) throws Throwable {
    }
}

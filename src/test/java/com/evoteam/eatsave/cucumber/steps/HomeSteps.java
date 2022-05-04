package com.evoteam.eatsave.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.web.client.RestTemplate;


public class HomeSteps {
    private RestTemplate restTemplate;
    @BeforeEach
    public void setUp() {

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

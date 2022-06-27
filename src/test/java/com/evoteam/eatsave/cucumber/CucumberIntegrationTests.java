package com.evoteam.eatsave.cucumber;

import com.evoteam.eatsave.EatSaveApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@SpringBootTest(classes = { EatSaveApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberOptions(plugin = {"pretty"}, tags = "", features = "src/test/resources/features")
public class CucumberIntegrationTests {
}

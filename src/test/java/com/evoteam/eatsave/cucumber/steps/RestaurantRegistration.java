package com.evoteam.eatsave.cucumber.steps;

import com.evoteam.eatsave.api.domain.models.District;
import com.evoteam.eatsave.api.domain.models.Restaurant;
import com.evoteam.eatsave.api.domain.persistence.DistrictRepository;
import com.evoteam.eatsave.api.domain.persistence.RestaurantRepository;
import com.evoteam.eatsave.api.services.interfaces.DistrictsService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Do;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RestaurantRegistration {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private DistrictsService districtsService;
    private District expectedDistrict;
    private List<Map<String, String>> expectedRestaurants;
    private List<Restaurant> actualRestaurants;
    @BeforeEach
    public void setUp() {
        expectedRestaurants = new ArrayList<>();
        actualRestaurants = new ArrayList<>();
        restaurantRepository.deleteAll();
    }
    @Given("the following district {string}")
    public void theFollowingDistrict(String district) {
        expectedDistrict = districtsService.createDistrict(new District(null, district));
    }
    @Given("the following restaurants")
    public void theFollowingRestaurants(final List<Map<String,String>> restaurants) {
        expectedRestaurants = restaurants;
    }

    @When("the client register his restaurants")
    public void theClientRegisterHisRestaurants() {
        actualRestaurants = new ArrayList<>();
        expectedRestaurants.forEach(restaurant -> {
            actualRestaurants.add(
                    restaurantRepository.save(
                            new Restaurant(
                                    null,
                                    restaurant.get("internalId"),
                                    restaurant.get("description"),
                                    restaurant.get("address"),
                                    Double.parseDouble(restaurant.get("latitude")),
                                    Double.parseDouble(restaurant.get("longitude")),
                                    expectedDistrict
                            )
                    )
            );
        });
    }

    @Then("all the restaurants are registered")
    public void allTheRestaurantsAreRegistered() {
        Assertions.assertEquals(actualRestaurants.size(), 4);
    }
}

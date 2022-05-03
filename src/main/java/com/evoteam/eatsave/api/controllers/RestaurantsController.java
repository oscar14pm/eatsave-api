package com.evoteam.eatsave.api.controllers;

import com.evoteam.eatsave.api.domain.models.Restaurant;
import com.evoteam.eatsave.api.services.interfaces.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantsController {
    private final RestaurantService restaurantService;
    @GetMapping
    public ResponseEntity<List<Restaurant>> getRestaurants() {
        return ResponseEntity.ok().body(restaurantService.getRestaurants());
    }
}

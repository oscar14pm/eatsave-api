package com.evoteam.eatsave.api.controllers;

import com.evoteam.eatsave.api.domain.models.District;
import com.evoteam.eatsave.api.domain.models.Restaurant;
import com.evoteam.eatsave.api.services.interfaces.DistrictsService;
import com.evoteam.eatsave.api.services.interfaces.RestaurantService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantsController {
    private final RestaurantService restaurantService;
    private final DistrictsService districtsService;
    @GetMapping
    public ResponseEntity<List<Restaurant>> getRestaurants() {
        return ResponseEntity.ok().body(restaurantService.getRestaurants());
    }
    @GetMapping("/{internalId}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable("internalId") String internalId) {
        Restaurant foundRestaurant = restaurantService.getRestaurant(internalId);
        if (foundRestaurant == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundRestaurant);
        }
    }
    @PostMapping
    public ResponseEntity<?> createRestaurant(
            @RequestBody Map<String, String> payload,
            @RequestHeader("Authorization") String authHeader
    ) throws Exception {
        if (restaurantService.getRestaurant(payload.get("internalId")) == null) {
            payload.put("token", authHeader);
            Restaurant restaurant = restaurantService.buildRestaurant(payload);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/restaurants/create").toUriString());
            return ResponseEntity.created(uri).body(restaurant);
        } else {
            return new ResponseEntity<>("internal id is already taken", HttpStatus.BAD_REQUEST);
        }
    }
}

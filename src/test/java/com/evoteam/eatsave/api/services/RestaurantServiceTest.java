package com.evoteam.eatsave.api.services;

import com.evoteam.eatsave.api.domain.models.District;
import com.evoteam.eatsave.api.domain.models.Restaurant;
import com.evoteam.eatsave.api.domain.persistence.RestaurantRepository;
import com.evoteam.eatsave.api.services.implementations.RestaurantServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RestaurantServiceTest {
    @Mock
    private RestaurantRepository restaurantRepository;
    @InjectMocks
    private RestaurantServiceImpl restaurantService;
    private Restaurant res, res2;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        District district = new District(null, "Test 1");
        res = new Restaurant(null, "CHICKEN_1", "Chicken and Peru-Fusion", "Jr. Benavides", -12.0638284,-77.0749729, district);
        res2 = new Restaurant(null, "TERMINAL", "Good Sushi Restaurant", "Jr. Benavides", -12.0638284,-77.0749729, district);
    }
    @Test
    void getRestaurants() {
        when(restaurantRepository.findAll()).thenReturn(List.of(res, res2));
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        assertEquals(restaurants.size(), 2);
        assertEquals(restaurants.get(0).getClass(), Restaurant.class);
    }
    @Test
    void saveRestaurant() {
        when(restaurantRepository.save(Mockito.any(Restaurant.class))).thenReturn(res);
        Restaurant restaurant = restaurantService.createRestaurant(res);
        assertNotNull(restaurant);
        assertEquals(restaurant.getInternalId(), "CHICKEN_1");
    }
    @Test
    void getRestaurant() {
        when(restaurantRepository.findByInternalId(res.getInternalId())).thenReturn(res);
        Restaurant restaurant = restaurantService.getRestaurant("CHICKEN_1");
        assertNotNull(restaurant);
        assertEquals(restaurant.getInternalId(), "CHICKEN_1");
    }
}
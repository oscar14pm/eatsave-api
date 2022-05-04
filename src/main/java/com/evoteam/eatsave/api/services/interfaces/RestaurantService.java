package com.evoteam.eatsave.api.services.interfaces;

import com.evoteam.eatsave.api.domain.models.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantService {
    List<Restaurant> getRestaurants ();
    Restaurant getRestaurant (String internalId);
    Restaurant createRestaurant(Restaurant restaurant);
    Restaurant buildRestaurant(Map<String, String> payload);
}

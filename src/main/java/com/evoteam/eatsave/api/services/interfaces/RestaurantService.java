package com.evoteam.eatsave.api.services.interfaces;

import com.evoteam.eatsave.api.domain.models.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getRestaurants ();
    Restaurant getRestaurant (String businessName);
    Restaurant createRestaurant(Restaurant restaurant);
}

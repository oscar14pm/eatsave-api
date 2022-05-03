package com.evoteam.eatsave.api.services.implementations;

import com.evoteam.eatsave.api.domain.models.Restaurant;
import com.evoteam.eatsave.api.domain.persistence.RestaurantRepository;
import com.evoteam.eatsave.api.services.interfaces.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    @Override
    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurant(String internalId) {
        return restaurantRepository.findByInternalId(internalId);
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}

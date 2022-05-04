package com.evoteam.eatsave.api.services.implementations;

import com.evoteam.eatsave.api.domain.models.Client;
import com.evoteam.eatsave.api.domain.models.Restaurant;
import com.evoteam.eatsave.api.domain.models.User;
import com.evoteam.eatsave.api.domain.persistence.ClientRepository;
import com.evoteam.eatsave.api.domain.persistence.RestaurantRepository;
import com.evoteam.eatsave.api.services.interfaces.ClientService;
import com.evoteam.eatsave.api.services.interfaces.DistrictsService;
import com.evoteam.eatsave.api.services.interfaces.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final ClientService clientService;
    private final DistrictsService districtsService;
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

    @Override
    public Restaurant buildRestaurant(Map<String, String> payload) {
        Client loadedClient = clientService.loadClient(payload.get("token"));
        Restaurant newRestaurant = createRestaurant(new Restaurant(
                null,
                payload.get("internalId"),
                payload.get("description"),
                payload.get("address"),
                Double.parseDouble(payload.get("latitude")),
                Double.parseDouble(payload.get("longitude")),
                districtsService.getDistrict(payload.get("district"))
        ));
        clientService.addRestaurantToClient(loadedClient, payload.get("internalId"));
        return newRestaurant;
    }
}

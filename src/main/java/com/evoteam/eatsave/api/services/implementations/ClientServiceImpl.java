package com.evoteam.eatsave.api.services.implementations;

import com.evoteam.eatsave.api.domain.models.Client;
import com.evoteam.eatsave.api.domain.models.Restaurant;
import com.evoteam.eatsave.api.domain.models.User;
import com.evoteam.eatsave.api.domain.persistence.ClientRepository;
import com.evoteam.eatsave.api.domain.persistence.RestaurantRepository;
import com.evoteam.eatsave.api.services.interfaces.ClientService;
import com.evoteam.eatsave.api.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserService userService;
    @Override
    public Client createClient(Map<String, String> payload) {
        Client createdClient = buildClient(payload);
        return clientRepository.save(createdClient);
    }

    @Override
    public Client loadClient(String authHeader) {
        User loadedUser = userService.getCurrentUser(authHeader);
        return clientRepository.findByUser(loadedUser);
    }

    @Override
    public void addRestaurantToClient(Client client, String restaurant) {
        Restaurant loadedRestaurant = restaurantRepository.findByInternalId(restaurant);
        client.getRestaurants().add(loadedRestaurant);
    }

    public Client buildClient(Map<String, String> payload) {
        User user = userService.createUser(new User(
                null,
                payload.get("firstName"),
                payload.get("lastName"),
                payload.get("username"),
                payload.get("password"),
                new ArrayList<>()
        ));
        userService.addRoleToUser(payload.get("username"), "ROLE_CLIENT");
        return new Client(null, payload.get("businessName"), new ArrayList<>(), user);
    }
}

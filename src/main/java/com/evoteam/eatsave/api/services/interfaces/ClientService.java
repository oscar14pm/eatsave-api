package com.evoteam.eatsave.api.services.interfaces;

import com.evoteam.eatsave.api.domain.models.Client;

import java.util.Map;

public interface ClientService {
    Client createClient(Client client);
    Client loadClient(String authHeader);
    void addRestaurantToClient(Client client, String restaurant);

    Client buildClient(Map<String, String> payload);
}
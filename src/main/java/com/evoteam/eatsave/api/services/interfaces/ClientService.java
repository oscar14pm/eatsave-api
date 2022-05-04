package com.evoteam.eatsave.api.services.interfaces;

import com.evoteam.eatsave.api.domain.models.Client;

import java.util.Map;

public interface ClientService {
    Client createClient(Map<String, String> payload);
}

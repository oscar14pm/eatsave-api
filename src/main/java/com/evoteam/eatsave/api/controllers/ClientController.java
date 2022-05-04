package com.evoteam.eatsave.api.controllers;

import com.evoteam.eatsave.api.domain.models.Client;
import com.evoteam.eatsave.api.services.interfaces.ClientService;
import com.evoteam.eatsave.api.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Map<String, String> payload) {
        if (userService.getUser(payload.get("username")) == null) {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/clients").toUriString());
            return ResponseEntity.created(uri).body(clientService.createClient(payload));
        } else {
            return (ResponseEntity<Client>) ResponseEntity.badRequest();
        }
    }
}

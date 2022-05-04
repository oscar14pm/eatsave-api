package com.evoteam.eatsave.api.domain.persistence;

import com.evoteam.eatsave.api.domain.models.Client;
import com.evoteam.eatsave.api.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByBusinessName(String businessName);
    Client findByUser(User user);
}

package com.evoteam.eatsave.api.domain.persistence;

import com.evoteam.eatsave.api.domain.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Restaurant findByInternalId (String name);
}

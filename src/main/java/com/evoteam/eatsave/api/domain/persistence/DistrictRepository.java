package com.evoteam.eatsave.api.domain.persistence;

import com.evoteam.eatsave.api.domain.models.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District, Long> {
    District findByName(String name);
}

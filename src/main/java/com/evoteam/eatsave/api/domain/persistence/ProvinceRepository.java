package com.evoteam.eatsave.api.domain.persistence;

import com.evoteam.eatsave.api.domain.models.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepository extends JpaRepository<Province, Long> {
    Province findByName(String name);
}

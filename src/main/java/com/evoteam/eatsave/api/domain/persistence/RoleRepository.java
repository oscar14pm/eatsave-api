package com.evoteam.eatsave.api.domain.persistence;

import com.evoteam.eatsave.api.domain.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

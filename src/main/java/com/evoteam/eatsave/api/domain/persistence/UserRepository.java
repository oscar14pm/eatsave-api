package com.evoteam.eatsave.repository;

import com.evoteam.eatsave.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

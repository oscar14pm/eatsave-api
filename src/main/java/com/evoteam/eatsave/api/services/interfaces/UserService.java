package com.evoteam.eatsave.api.services.interfaces;

import com.evoteam.eatsave.api.domain.models.Role;
import com.evoteam.eatsave.api.domain.models.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    User getCurrentUser(String authorizationHeader);
    List<User> getUsers();
}

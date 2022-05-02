package com.evoteam.eatsave.service;

import com.evoteam.eatsave.domain.Role;
import com.evoteam.eatsave.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}

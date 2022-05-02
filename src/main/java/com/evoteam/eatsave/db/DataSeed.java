package com.evoteam.eatsave.db;

import com.evoteam.eatsave.api.domain.models.Role;
import com.evoteam.eatsave.api.domain.models.User;
import com.evoteam.eatsave.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;

public class DataSeed implements CommandLineRunner {
    @Autowired
    UserService userService;
    @Override
    public void run(String... args) throws Exception {
        createRoles();
        createUsers();
    }
    private void createRoles() {
        userService.saveRole(new Role(null, "ROLE_CLIENT"));
        userService.saveRole(new Role(null, "ROLE_LAWYER"));
        userService.saveRole(new Role(null, "ROLE_ADMIN"));
    }
    private void createUsers() {
        userService.createUser(new User(null, "John", "Smith", "john", "12345", new ArrayList<>()));
        userService.createUser(new User(null, "Tony", "Green", "tony", "12345", new ArrayList<>()));
        userService.createUser(new User(null, "Alessandro", "Chumpitaz", "hyper", "12345", new ArrayList<>()));

        userService.addRoleToUser("hyper", "ROLE_ADMIN");
        userService.addRoleToUser("john", "ROLE_LAWYER");
        userService.addRoleToUser("tony", "ROLE_LAWYER");
    }
}

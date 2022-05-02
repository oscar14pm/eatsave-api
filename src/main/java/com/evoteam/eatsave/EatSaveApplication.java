package com.evoteam.eatsave;

import com.evoteam.eatsave.api.domain.models.Role;
import com.evoteam.eatsave.api.service.UserService;
import com.evoteam.eatsave.api.domain.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class EatSaveApplication {

    public static void main(String[] args) {
        SpringApplication.run(EatSaveApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_CONSULTANT"));
            userService.saveRole(new Role(null, "ROLE_CLIENT"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));

            userService.saveUser(new User(null, "John", "john", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Alessandro", "hyper", "12345", new ArrayList<>()));

            userService.addRoleToUser("hyper", "ROLE_ADMIN");
            userService.addRoleToUser("hyper", "ROLE_CLIENT");
            userService.addRoleToUser("john", "ROLE_CONSULTANT");
        };
    }

}

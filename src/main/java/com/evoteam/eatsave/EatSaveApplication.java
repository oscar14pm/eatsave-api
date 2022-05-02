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
}

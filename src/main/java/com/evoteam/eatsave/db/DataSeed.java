package com.evoteam.eatsave.db;

import com.evoteam.eatsave.api.domain.models.*;
import com.evoteam.eatsave.api.services.interfaces.DistrictsService;
import com.evoteam.eatsave.api.services.interfaces.ProvinceService;
import com.evoteam.eatsave.api.services.interfaces.RestaurantService;
import com.evoteam.eatsave.api.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Component
public class DataSeed implements CommandLineRunner {
    @Autowired
    UserService userService;
    @Autowired
    DistrictsService districtsService;
    @Autowired
    ProvinceService provinceService;
    @Autowired
    RestaurantService restaurantService;
    @Override
    public void run(String... args) throws Exception {
        if (!Objects.equals(System.getenv("SPRING_ENV"), "prod")) {
            createRoles();
            createUsers();
            createDistricts();
            createProvinces();
            createRestaurants();
        }
    }
    private void createRoles() {
        userService.saveRole(new Role(null, "ROLE_CLIENT"));
        userService.saveRole(new Role(null, "ROLE_CONSULTANT"));
        userService.saveRole(new Role(null, "ROLE_ADMIN"));
    }
    private void createUsers() {
        userService.createUser(new User(null, "John", "Smith", "john", "12345", new ArrayList<>()));
        userService.createUser(new User(null, "Tony", "Green", "tony", "12345", new ArrayList<>()));
        userService.createUser(new User(null, "Alessandro", "Chumpitaz", "hyper", "12345", new ArrayList<>()));

        userService.addRoleToUser("hyper", "ROLE_ADMIN");
        userService.addRoleToUser("john", "ROLE_CONSULTANT");
        userService.addRoleToUser("tony", "ROLE_CONSULTANT");
    }
    private void createDistricts() {
        districtsService.createDistrict(new District(null, "St. Michael"));
        districtsService.createDistrict(new District(null, "F District"));
        districtsService.createDistrict(new District(null, "Test 123"));
        districtsService.createDistrict(new District(null, "Contract"));
    }
    private void createProvinces() {
        provinceService.createProvince(new Province(null, "Lima", new ArrayList<>()));
        provinceService.createProvince(new Province(null, "Lima2", new ArrayList<>()));

        provinceService.addDistrictToProvince("Lima", "St. Michael");
        provinceService.addDistrictToProvince("Lima", "F District");
        provinceService.addDistrictToProvince("Lima", "Test 123");
        provinceService.addDistrictToProvince("Lima", "Contract");
    }
    private void createRestaurants() {
        restaurantService.createRestaurant(new Restaurant(null, "ALENKAS_1", "ASDF", "Jr. Benavides", -12.0638284,-77.0749729, districtsService.getDistrict("St. Michael")));
        restaurantService.createRestaurant(new Restaurant(null, "ALENKAS_2", "ASDF", "Av. Mecanica", -9.0632384,-35.0749729, districtsService.getDistrict("Test 123")));
        restaurantService.createRestaurant(new Restaurant(null, "ALENKAS_3", "ASDF", "Jr. Lima", -17.0638284,-79.0745729, districtsService.getDistrict("Contract")));
    }
    private void createClients() {

    }
}

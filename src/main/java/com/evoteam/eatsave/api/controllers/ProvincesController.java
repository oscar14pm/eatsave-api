package com.evoteam.eatsave.api.controllers;

import com.evoteam.eatsave.api.domain.models.Province;
import com.evoteam.eatsave.api.services.interfaces.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/provinces")
@RequiredArgsConstructor
public class ProvincesController {
    private final ProvinceService provinceService;

    @GetMapping()
    public ResponseEntity<List<Province>>getProvinces(){
        return ResponseEntity.ok().body(provinceService.getProvinces());
    }
}

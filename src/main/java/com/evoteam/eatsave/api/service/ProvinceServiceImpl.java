package com.evoteam.eatsave.api.service;

import com.evoteam.eatsave.api.domain.models.District;
import com.evoteam.eatsave.api.domain.models.Province;
import com.evoteam.eatsave.api.domain.persistence.ProvinceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProvinceServiceImpl implements ProvinceService {
    private final ProvinceRepository provinceRepository;
    @Override
    public List<Province> getProvinces() {
        return provinceRepository.findAll();
    }

    @Override
    public Province getProvince(String name) {
        return provinceRepository.findByName(name);
    }

    @Override
    public Province createProvince(Province province) {
        return provinceRepository.save(province);
    }

    @Override
    public Province deleteProvince(String name) {
        return null;
    }
}

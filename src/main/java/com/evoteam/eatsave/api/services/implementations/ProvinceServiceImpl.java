package com.evoteam.eatsave.api.services.implementations;

import com.evoteam.eatsave.api.domain.models.District;
import com.evoteam.eatsave.api.domain.models.Province;
import com.evoteam.eatsave.api.domain.persistence.DistrictRepository;
import com.evoteam.eatsave.api.domain.persistence.ProvinceRepository;
import com.evoteam.eatsave.api.services.interfaces.ProvinceService;
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
    private final DistrictRepository districtRepository;
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
    @Override
    public void addDistrictToProvince(String provinceName, String districtName) {
        Province province = provinceRepository.findByName(provinceName);
        District district = districtRepository.findByName(districtName);
        province.getDistricts().add(district);
    }
}

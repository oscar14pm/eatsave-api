package com.evoteam.eatsave.api.services.implementations;

import com.evoteam.eatsave.api.domain.models.District;
import com.evoteam.eatsave.api.domain.persistence.DistrictRepository;
import com.evoteam.eatsave.api.services.interfaces.DistrictsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DistrictsServiceImpl implements DistrictsService {
    private final DistrictRepository districtRepository;
    @Override
    public List<District> getDistricts() {
        return districtRepository.findAll();
    }

    @Override
    public District getDistrict(String name) {
        return districtRepository.findByName(name);
    }

    @Override
    public District createDistrict(District district) {
        return districtRepository.save(district);
    }

    @Override
    public District deleteDistrict(String name) {
        return null;
    }
}

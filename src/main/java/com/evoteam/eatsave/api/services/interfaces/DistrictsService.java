package com.evoteam.eatsave.api.services.interfaces;

import com.evoteam.eatsave.api.domain.models.District;

import java.util.List;

public interface DistrictsService {
    List<District> getDistricts();
    District getDistrict(String name);
    District createDistrict(District district);
    District deleteDistrict(String name);
}

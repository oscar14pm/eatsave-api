package com.evoteam.eatsave.api.service;

import com.evoteam.eatsave.api.domain.models.District;
import com.evoteam.eatsave.api.domain.models.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> getProvinces();
    Province getProvince(String name);
    Province createProvince(Province province);
    Province deleteProvince(String name);
}

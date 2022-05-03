package com.evoteam.eatsave.api.services.interfaces;

import com.evoteam.eatsave.api.domain.models.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> getProvinces();
    Province getProvince(String name);
    Province createProvince(Province province);
    Province deleteProvince(String name);
    void addDistrictToProvince(String provinceName, String districtName);
}

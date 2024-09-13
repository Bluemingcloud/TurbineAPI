package com.turbine.api.service;

import com.turbine.api.entity.Business;

import java.util.List;

public interface BusinessService {

    List<Business> getBusinessList();
    Business getBusinessById(Long id);
    Business saveBusiness(Business business);
    void deleteBusiness(List<Long> ids);
}

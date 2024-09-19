package com.turbine.api.service;

import com.turbine.api.entity.Business;

import java.util.List;
import java.util.Optional;

public interface BusinessService {

    List<Business> getBusinessList();
    Business saveBusiness(Business business);
    void deleteBusiness(List<Long> ids);
    Optional<Business> getBusinessByBno(Long bno);
}

package com.turbine.api.service;

import com.turbine.api.entity.Business;
import com.turbine.api.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("businessService")
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    BusinessRepository businessRepository;

    @Override
    public List<Business> getBusinessList() {
        return businessRepository.findAll();
    }
}

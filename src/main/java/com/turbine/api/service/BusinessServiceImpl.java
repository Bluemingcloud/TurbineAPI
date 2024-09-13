package com.turbine.api.service;

import com.turbine.api.entity.Business;
import com.turbine.api.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service("businessService")
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    BusinessRepository businessRepository;

    @Override
    public List<Business> getBusinessList() {
        return businessRepository.findAllByOrderByBnoDesc();
    }

    @Override
    public Business getBusinessById(Long id) {
        return businessRepository.findById(id).get();
    }

    @Override
    public Business saveBusiness(Business business) {
        return businessRepository.save(business);
    }

    @Override
    public void deleteBusiness(List<Long> ids) {
        businessRepository.deleteAllById(ids);
    }
}

package com.turbine.api.repository;

import com.turbine.api.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessRepository extends JpaRepository<Business, Long> {
    List<Business> findAllByOrderByBnoDesc();
}

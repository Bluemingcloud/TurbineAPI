package com.turbine.api.controller;

import com.turbine.api.entity.Business;
import com.turbine.api.entity.Marker;
import com.turbine.api.service.BusinessService;
import com.turbine.api.service.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turbine/api")
public class TurbineAPIRestController {

    @Autowired
    @Qualifier("businessService")
    private BusinessService businessService;

    @Autowired
    @Qualifier("markerService")
    private MarkerService markerService;

    @GetMapping("/get/business/all")
    public List<Business> getTurbineList() {
        return businessService.getBusinessList();
    }

    @GetMapping("/get/business/{id}")
    public List<Business> getTurbine(@PathVariable("id") Long id) {
        return businessService.getBusinessList();
    }

    @GetMapping("/get/marker/{id}")
    public List<Marker> getMarkerList(@PathVariable("id") Long id) {
        return markerService.getMarkersById(id);
    }

    @PostMapping("/post")
    public String home() {
        return "Hello Turbine";
    }
}

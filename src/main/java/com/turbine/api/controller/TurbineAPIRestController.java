package com.turbine.api.controller;

import com.turbine.api.entity.Business;
import com.turbine.api.entity.Marker;
import com.turbine.api.service.BusinessService;
import com.turbine.api.service.MarkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turbine/api")
public class TurbineAPIRestController {

    private static final Logger log = LoggerFactory.getLogger(TurbineAPIRestController.class);
    @Autowired
    @Qualifier("businessService")
    private BusinessService businessService;

    @Autowired
    @Qualifier("markerService")
    private MarkerService markerService;

    //Business
    //GET
    @GetMapping("/get/business/all")
    public List<Business> getTurbineList() {
        return businessService.getBusinessList();
    }

    //POST
    @PostMapping("/post/business/add")
    public ResponseEntity<Business> addBusiness(@RequestBody Business business) {
        try {
            // 비즈니스 로직에서 유효성 검사 등을 진행 후 저장
            Business savedBusiness = businessService.saveBusiness(business);
            // 성공적으로 저장된 경우 201 Created 반환
            return new ResponseEntity<>(savedBusiness, HttpStatus.CREATED);

        } catch (Exception e) {
            // 실패했을 경우, 400 Bad Request 반환
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //POST
    @PostMapping("/post/business/update/{bno}")
    public ResponseEntity<Business> updateBusiness(@PathVariable Long bno, @RequestBody Business business) {
        try {
            // 비즈니스 로직에서 기존 비즈니스가 존재하는지 확인
            Optional<Business> existingBusiness = businessService.getBusinessByBno(bno);
            if (existingBusiness.isPresent()) {
                // 업데이트할 엔티티에 기존 ID를 설정
                business.setBno(bno);
                Business updatedBusiness = businessService.saveBusiness(business);
                // 성공적으로 업데이트된 경우 200 OK 반환
                return new ResponseEntity<>(updatedBusiness, HttpStatus.OK);
            } else {
                // 비즈니스가 존재하지 않으면 404 Not Found 반환
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // 실패했을 경우, 400 Bad Request 반환
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //DELETE
    @PostMapping("/delete/business")
    public ResponseEntity<Void> deleteBusiness(@RequestBody List<Long> ids) {
        try {
            businessService.deleteBusiness(ids);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Marker
    //GET
    @GetMapping("/get/marker/{bno}")
    public List<Marker> getMarkerList(@PathVariable("bno") Long bno) {
        System.out.println(markerService.getMarkersByBno(bno).toString());
        return markerService.getMarkersByBno(bno);
    }

}

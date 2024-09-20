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
    // Marker 추가
    @PostMapping("/post/marker/add")
    public ResponseEntity<Marker> addMarker(@RequestBody Marker marker) {
        try {
            // 마커 추가 로직
            Marker savedMarker = markerService.saveMarker(marker);
            return new ResponseEntity<>(savedMarker, HttpStatus.CREATED); // 201 Created 반환
        } catch (Exception e) {
            // 오류 발생 시 400 Bad Request 반환
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    // Marker 업데이트
    @PostMapping("/post/marker/update/{mno}")
    public ResponseEntity<Marker> updateMarker(@PathVariable Long mno, @RequestBody Marker marker) {
        try {
            // 기존 마커가 존재하는지 확인
            Optional<Marker> existingMarkerOpt = markerService.getMarkerByMno(mno);
            if (existingMarkerOpt.isPresent()) {
                Marker existingMarker = existingMarkerOpt.get();

                // 기존 마커에 새로운 값 덮어쓰기 (Null 체크를 통해 선택적 업데이트)
                if (marker.getLatitude() != null) {
                    existingMarker.setLatitude(marker.getLatitude());
                }
                if (marker.getLongitude() != null) {
                    existingMarker.setLongitude(marker.getLongitude());
                }
                if (marker.getDegree() != null) {
                    existingMarker.setDegree(marker.getDegree());
                }
                if (marker.getTitle() != null) {
                    existingMarker.setTitle(marker.getTitle());
                }
                if (marker.getModel() != null) {
                    existingMarker.setModel(marker.getModel());
                }
                if (marker.getUpdate() != null) {
                    existingMarker.setUpdate(marker.getUpdate());
                }

                // 다른 필드들도 같은 방식으로 덮어쓰기

                // 업데이트된 마커 저장
                Marker updatedMarker = markerService.saveMarker(existingMarker);

                // 성공적으로 업데이트된 경우 200 OK 반환
                return new ResponseEntity<>(updatedMarker, HttpStatus.OK);
            } else {
                // 마커가 존재하지 않으면 404 Not Found 반환
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // 오류가 발생한 경우 400 Bad Request 반환
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    // Marker 삭제
    @DeleteMapping("/delete/marker/{mno}")
    public ResponseEntity<Void> deleteMarker(@PathVariable Long mno) {
        try {
            markerService.deleteMarkerById(mno); // 마커 삭제 서비스 호출
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}

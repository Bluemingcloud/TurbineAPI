package com.turbine.api;

import com.turbine.api.entity.Business;
import com.turbine.api.entity.Marker;
import com.turbine.api.repository.BusinessRepository;
import com.turbine.api.repository.MarkerRepository;
import com.turbine.api.service.BusinessService;
import com.turbine.api.service.MarkerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testCode01 {

    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private MarkerRepository markerRepository;
    @Autowired
    @Qualifier("businessService")
    private BusinessService businessService;
    @Autowired
    @Qualifier("markerService")
    private MarkerService markerService;

//    @Test
//    public void test() {
//        Business business = Business.builder()
//                .title("test")
//                .build();
//
//        businessRepository.save(business);
//
//        System.out.println(businessRepository.findById(1L).get());
//
//    }

    @Test
    public void test01() {

//        Marker marker = Marker.builder()
//                .bno(1L)
//                .model("doosan02")
//                .latitude(10.0)
//                .longitude(13.0)
//                .degree(230L)
//                .build();
//
//        markerRepository.save(marker);

        System.out.println(markerService.getMarkersByBno(1L).toString());
        System.out.println(businessService.getBusinessList().toString());
    }

    @Test
    public void test02() {
//        Marker marker = Marker.builder()
//                .bno(7L)
//                .model("temp")
//                .latitude(37.481231)
//                .longitude(126.873596)
//                .degree(230L)
//                .build();
//
//        Marker marker2 = Marker.builder()
//                .bno(11L)
//                .model("temp")
//                .latitude(37.505950)
//                .longitude(127.069139)
//                .degree(230L)
//                .build();
//
//        markerRepository.save(marker);

    }
}

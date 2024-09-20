package com.turbine.api.service;

import com.turbine.api.entity.Marker;

import java.util.List;
import java.util.Optional;

public interface MarkerService {

    List<Marker> getMarkersByBno(Long bno);
    // 마커 저장
    Marker saveMarker(Marker marker);

    // 마커 검색 (mno로 검색)
    Optional<Marker> getMarkerByMno(Long mno);
    //마커 삭제
    void deleteMarkerById(Long mno);

}

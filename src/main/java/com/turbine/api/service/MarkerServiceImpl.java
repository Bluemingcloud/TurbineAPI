package com.turbine.api.service;

import com.turbine.api.entity.Marker;
import com.turbine.api.repository.MarkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("markerService")
public class MarkerServiceImpl implements MarkerService {

    @Autowired
    private MarkerRepository markerRepository;

    @Override
    public List<Marker> getMarkersByBno(Long bno) {
        return markerRepository.findByBno(bno);
    }

    // 마커 저장 로직 구현
    @Override
    public Marker saveMarker(Marker marker) {
        return markerRepository.save(marker); // 마커 저장
    }

    @Override
    public Optional<Marker> getMarkerByMno(Long mno) {
        return markerRepository.findById(mno);
    }

    @Override
    public void deleteMarkerById(Long mno) {
        markerRepository.deleteById(mno); // 마커 삭제
    }

}

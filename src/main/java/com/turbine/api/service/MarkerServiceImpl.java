package com.turbine.api.service;

import com.turbine.api.entity.Marker;
import com.turbine.api.repository.MarkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("markerService")
public class MarkerServiceImpl implements MarkerService {

    @Autowired
    private MarkerRepository markerRepository;

    @Override
    public List<Marker> getMarkersByBno(Long bno) {
        return markerRepository.findByBno(bno);
    }

}

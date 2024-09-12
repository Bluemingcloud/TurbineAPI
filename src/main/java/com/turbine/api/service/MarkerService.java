package com.turbine.api.service;

import com.turbine.api.entity.Marker;

import java.util.List;

public interface MarkerService {

    List<Marker> getMarkersById(Long bno);

}

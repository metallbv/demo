package com.example.demo.service;

import com.example.demo.model.Route;
import com.example.demo.repository.RoutesRepository;
import com.example.demo.entity.dto.ReponseRouteDto;
import com.example.demo.entity.dto.RouteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteService {

  private ModelMapper modelMapper = new ModelMapper();

  @Autowired
  private RoutesRepository routesRepository;

  public ReponseRouteDto findRouteOfDepSidArrSid(Long dep_sid, Long arr_sid) {

    Route route = routesRepository.findRouteOfDepSidArrSid(dep_sid, arr_sid);
    ReponseRouteDto reponseRouteDto = new ReponseRouteDto();
    reponseRouteDto.setDep_sid(dep_sid);
    reponseRouteDto.setArr_sid(arr_sid);
    if (route != null) {
      reponseRouteDto.setDirect_bus_route(true);
    } else {
      reponseRouteDto.setDirect_bus_route(false);
    }
    return reponseRouteDto;
  }

  public List<RouteDto> findAllRoutesOfDepSidArrSid(Long dep_sid, Long arr_sid) {

    return routesRepository
      .findAllRoutesOfDepSidArrSid(dep_sid, arr_sid)
      .stream()
      .map(route -> new RouteDto(){{
        setRouteId(route.getRouteId());
        setStationIdList(route.getStationIdList());
      }})
      .collect(Collectors.toList());

  }
}

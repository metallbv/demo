package com.example.demo.controller;

import com.example.demo.repository.RoutesRepository;
import com.example.demo.entity.dto.ReponseRouteDto;
import com.example.demo.entity.dto.RouteDto;
import com.example.demo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RouteController {

  @Autowired
  private RouteService routeService;

  private RoutesRepository repository;

  public RouteController(RoutesRepository repository) {
    this.repository = repository;
    /*ArrayList<Long> routesList = new ArrayList<Long>();
    routesList.add(1L);
    routesList.add(2L);
    routesList.add(3L);
    Route route = new Route();
    route.setRouteId(10L);
    route.setStationIdList(routesList);
    repository.save(route);*/
  }

  @GetMapping("/api/allDirects")
  public List<RouteDto> getAllRoutes() {
    return repository.findAll().stream()
      .map(route -> new RouteDto(){{
        setRouteId(route.getRouteId());
        setStationIdList(route.getStationIdList());
      }})
      .collect(Collectors.toList());
  }

  @GetMapping(value = "/api/direct", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> findRouteOfDepSidArrSid(
    @RequestParam String dep_sid, @RequestParam String arr_sid) {
    ReponseRouteDto response = routeService.findRouteOfDepSidArrSid(Long.parseLong(dep_sid), Long.parseLong(arr_sid));
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}

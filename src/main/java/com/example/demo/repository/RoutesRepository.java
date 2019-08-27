package com.example.demo.repository;


import com.example.demo.model.Route;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoutesRepository extends CrudRepository<Route, Integer> {

  List<Route> findAll();

  @Query(value = "SELECT r FROM Route r " +
    "JOIN r.stationIdList deps " +
    "JOIN r.stationIdList arrs " +
    "WHERE deps=:dep_sid and arrs=:arr_sid " , countQuery = "1")
  Route findRouteOfDepSidArrSid(@Param("dep_sid") Long dep_sid, @Param("arr_sid") Long arr_sid);

  @Query("SELECT r FROM Route r " +
    "JOIN r.stationIdList deps " +
    "JOIN r.stationIdList arrs " +
    "WHERE deps=:dep_sid and arrs=:arr_sid" )
  List<Route> findAllRoutesOfDepSidArrSid(@Param("dep_sid") Long dep_sid, @Param("arr_sid") Long arr_sid);

}

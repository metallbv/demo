package com.example.demo.rest;

import java.util.List;

public class RouteDto {

  private long routeId;
  private List<Long> stationIdList;

  public long getRouteId() {
    return routeId;
  }

  public void setRouteId(long routeId) {
    this.routeId = routeId;
  }

  public List<Long> getStationIdList() {
    return stationIdList;
  }

  public void setStationIdList(List<Long> stationIdList) {
    this.stationIdList = stationIdList;
  }

}

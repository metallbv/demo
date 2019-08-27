package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Route implements Serializable {

  @Id
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "route_Id", unique = true, nullable = false)
  private Long routeId;

  @ElementCollection
  private List<Long> stationIdList = new ArrayList<Long>();

  public Route() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getRouteId() {
    return routeId;
  }

  public void setRouteId(Long routeId) {
    this.routeId = routeId;
  }

  public List<Long> getStationIdList() {
    return stationIdList;
  }

  public void setStationIdList(List<Long> stationIdList) {
    this.stationIdList = stationIdList;
  }

}

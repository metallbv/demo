package com.example.demo.rest;

public class ReponseRouteDto {
  private long dep_sid;
  private long arr_sid;
  private Boolean direct_bus_route;

  public long getDep_sid() {
    return dep_sid;
  }

  public void setDep_sid(long dep_sid) {
    this.dep_sid = dep_sid;
  }

  public long getArr_sid() {
    return arr_sid;
  }

  public void setArr_sid(long arr_sid) {
    this.arr_sid = arr_sid;
  }

  public Boolean getDirect_bus_route() {
    return direct_bus_route;
  }

  public void setDirect_bus_route(Boolean direct_bus_route) {
    this.direct_bus_route = direct_bus_route;
  }
}

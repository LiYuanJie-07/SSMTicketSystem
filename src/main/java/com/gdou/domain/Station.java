package com.gdou.domain;

import java.io.Serializable;

/**
 * 站台实体类
 */
public class Station implements Serializable {
    private Integer stationid;

    private String startstation;

    private String endstation;

    private String starttime;

    private String arrivetime;

    private Integer usetime;

    private Integer distance;

    public Integer getStationid() {
        return stationid;
    }

    public void setStationid(Integer stationid) {
        this.stationid = stationid;
    }

    public String getStartstation() {
        return startstation;
    }

    public void setStartstation(String startstation) {
        this.startstation = startstation == null ? null : startstation.trim();
    }

    public String getEndstation() {
        return endstation;
    }

    public void setEndstation(String endstation) {
        this.endstation = endstation == null ? null : endstation.trim();
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getArrivetime() {
        return arrivetime;
    }

    public void setArrivetime(String arrivetime) {
        this.arrivetime = arrivetime;
    }

    public Integer getUsetime() {
        return usetime;
    }

    public void setUsetime(Integer usetime) {
        this.usetime = usetime;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationid=" + stationid +
                ", startstation='" + startstation + '\'' +
                ", endstation='" + endstation + '\'' +
                ", starttime=" + starttime +
                ", arrivetime=" + arrivetime +
                ", usetime=" + usetime +
                ", distance=" + distance +
                '}';
    }
}
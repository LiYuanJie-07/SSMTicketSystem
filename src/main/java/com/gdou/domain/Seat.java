package com.gdou.domain;

import java.io.Serializable;

/**
 * 座位实体类
 */
public class Seat implements Serializable {
    private Integer seatid;

    private Integer trainid;

    private String seattype;

    private Integer carriage;

    private Integer status;

    private String seatlocation;

    private String trainname;

    public Integer getSeatid() {
        return seatid;
    }

    public void setSeatid(Integer seatid) {
        this.seatid = seatid;
    }

    public Integer getTrainid() {
        return trainid;
    }

    public void setTrainid(Integer trainid) {
        this.trainid = trainid;
    }

    public String getSeattype() {
        return seattype;
    }

    public void setSeattype(String seattype) {
        this.seattype = seattype == null ? null : seattype.trim();
    }

    public Integer getCarriage() {
        return carriage;
    }

    public void setCarriage(Integer carriage) {
        this.carriage = carriage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSeatlocation() {
        return seatlocation;
    }

    public void setSeatlocation(String seatlocation) {
        this.seatlocation = seatlocation == null ? null : seatlocation.trim();
    }

    public String getTrainname() {
        return trainname;
    }

    public void setTrainname(String trainname) {
        this.trainname = trainname;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatid=" + seatid +
                ", trainid=" + trainid +
                ", seattype='" + seattype + '\'' +
                ", carriage=" + carriage +
                ", status=" + status +
                ", seatlocation='" + seatlocation + '\'' +
                ", trainname='" + trainname + '\'' +
                '}';
    }
}
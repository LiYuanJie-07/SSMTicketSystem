package com.gdou.domain;

import java.io.Serializable;

/**
 * 火车实体类
 */
public class Train implements Serializable {
    private Integer trainid;

    private String trainname;

    private String traintype;

    private String trainlocation;

    private Integer specialClassSeat;

    private Integer firstClassSeat;

    private Integer secondClassSeat;

    private Double trainprice;

    public Integer getTrainid() {
        return trainid;
    }

    public void setTrainid(Integer trainid) {
        this.trainid = trainid;
    }

    public String getTrainname() {
        return trainname;
    }

    public void setTrainname(String trainname) {
        this.trainname = trainname == null ? null : trainname.trim();
    }

    public String getTraintype() {
        return traintype;
    }

    public void setTraintype(String traintype) {
        this.traintype = traintype == null ? null : traintype.trim();
    }

    public String getTrainlocation() {
        return trainlocation;
    }

    public void setTrainlocation(String trainlocation) {
        this.trainlocation = trainlocation == null ? null : trainlocation.trim();
    }

    public Integer getSpecialClassSeat() {
        return specialClassSeat;
    }

    public void setSpecialClassSeat(Integer specialClassSeat) {
        this.specialClassSeat = specialClassSeat;
    }

    public Integer getFirstClassSeat() {
        return firstClassSeat;
    }

    public void setFirstClassSeat(Integer firstClassSeat) {
        this.firstClassSeat = firstClassSeat;
    }

    public Integer getSecondClassSeat() {
        return secondClassSeat;
    }

    public void setSecondClassSeat(Integer secondClassSeat) {
        this.secondClassSeat = secondClassSeat;
    }

    public Double getTrainprice() {
        return trainprice;
    }

    public void setTrainprice(Double trainprice) {
        this.trainprice = trainprice;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainid=" + trainid +
                ", trainname='" + trainname + '\'' +
                ", traintype='" + traintype + '\'' +
                ", trainlocation='" + trainlocation + '\'' +
                ", specialClassSeat=" + specialClassSeat +
                ", firstClassSeat=" + firstClassSeat +
                ", secondClassSeat=" + secondClassSeat +
                ", trainprice=" + trainprice +
                '}';
    }
}
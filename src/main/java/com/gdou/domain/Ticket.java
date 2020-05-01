package com.gdou.domain;

import java.io.Serializable;

/**
 * 车票实体类
 */
public class Ticket implements Serializable {
    private Integer ticketid;

    private Integer stationid;

    private Integer trainid;

    private String ticketStartstation;

    private String ticketEndstation;

    private String ticketStarttime;

    private String ticketArrivetime;

    private Integer ticketUsetime;

    private Double ticketprice;

    private String ticketTrainname;

    private String ticketTraintype;

    private Integer specialSeatNumber;

    private Integer firstSeatNumber;

    private Integer secondSeatNumber;

    public Integer getTicketid() {
        return ticketid;
    }

    public void setTicketid(Integer ticketid) {
        this.ticketid = ticketid;
    }

    public Integer getStationid() {
        return stationid;
    }

    public void setStationid(Integer stationid) {
        this.stationid = stationid;
    }

    public Integer getTrainid() {
        return trainid;
    }

    public void setTrainid(Integer trainid) {
        this.trainid = trainid;
    }

    public String getTicketStartstation() {
        return ticketStartstation;
    }

    public void setTicketStartstation(String ticketStartstation) {
        this.ticketStartstation = ticketStartstation == null ? null : ticketStartstation.trim();
    }

    public String getTicketEndstation() {
        return ticketEndstation;
    }

    public void setTicketEndstation(String ticketEndstation) {
        this.ticketEndstation = ticketEndstation == null ? null : ticketEndstation.trim();
    }

    public String getTicketStarttime() {
        return ticketStarttime;
    }

    public void setTicketStarttime(String ticketStarttime) {
        this.ticketStarttime = ticketStarttime;
    }

    public String getTicketArrivetime() {
        return ticketArrivetime;
    }

    public void setTicketArrivetime(String ticketArrivetime) {
        this.ticketArrivetime = ticketArrivetime;
    }

    public Integer getTicketUsetime() {
        return ticketUsetime;
    }

    public void setTicketUsetime(Integer ticketUsetime) {
        this.ticketUsetime = ticketUsetime;
    }

    public Double getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(Double ticketprice) {
        this.ticketprice = ticketprice;
    }

    public String getTicketTrainname() {
        return ticketTrainname;
    }

    public void setTicketTrainname(String ticketTrainname) {
        this.ticketTrainname = ticketTrainname == null ? null : ticketTrainname.trim();
    }

    public String getTicketTraintype() {
        return ticketTraintype;
    }

    public void setTicketTraintype(String ticketTraintype) {
        this.ticketTraintype = ticketTraintype == null ? null : ticketTraintype.trim();
    }

    public Integer getSpecialSeatNumber() {
        return specialSeatNumber;
    }

    public void setSpecialSeatNumber(Integer specialSeatNumber) {
        this.specialSeatNumber = specialSeatNumber;
    }

    public Integer getFirstSeatNumber() {
        return firstSeatNumber;
    }

    public void setFirstSeatNumber(Integer firstSeatNumber) {
        this.firstSeatNumber = firstSeatNumber;
    }

    public Integer getSecondSeatNumber() {
        return secondSeatNumber;
    }

    public void setSecondSeatNumber(Integer secondSeatNumber) {
        this.secondSeatNumber = secondSeatNumber;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketid=" + ticketid +
                ", stationid=" + stationid +
                ", trainid=" + trainid +
                ", ticketStartstation='" + ticketStartstation + '\'' +
                ", ticketEndstation='" + ticketEndstation + '\'' +
                ", ticketStarttime=" + ticketStarttime +
                ", ticketArrivetime=" + ticketArrivetime +
                ", ticketUsetime=" + ticketUsetime +
                ", ticketprice=" + ticketprice +
                ", ticketTrainname='" + ticketTrainname + '\'' +
                ", ticketTraintype='" + ticketTraintype + '\'' +
                ", specialSeatNumber=" + specialSeatNumber +
                ", firstSeatNumber=" + firstSeatNumber +
                ", secondSeatNumber=" + secondSeatNumber +
                '}';
    }
}
package com.gdou.domain;

import java.io.Serializable;

/**
 * 订单实体类
 */
public class Order implements Serializable {
    private String orderid;

    private Integer userid;

    private String orderUsername;

    private String orderIdcardname;

    private String orderIdcardnumber;

    private Integer ticketid;

    private String orderTrainname;

    private String orderStartstation;

    private String orderEndstation;

    private String orderStarttime;

    private String orderArrivetime;

    private Double orderPrice;

    private String ordertime;

    private String status;

    private Integer seatid;

    private Integer orderCarriage;

    private String orderSeattype;

    private String orderSeatlocation;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getOrderUsername() {
        return orderUsername;
    }

    public void setOrderUsername(String orderUsername) {
        this.orderUsername = orderUsername == null ? null : orderUsername.trim();
    }

    public String getOrderIdcardname() {
        return orderIdcardname;
    }

    public void setOrderIdcardname(String orderIdcardname) {
        this.orderIdcardname = orderIdcardname == null ? null : orderIdcardname.trim();
    }

    public String getOrderIdcardnumber() {
        return orderIdcardnumber;
    }

    public void setOrderIdcardnumber(String orderIdcardnumber) {
        this.orderIdcardnumber = orderIdcardnumber == null ? null : orderIdcardnumber.trim();
    }

    public Integer getTicketid() {
        return ticketid;
    }

    public void setTicketid(Integer ticketid) {
        this.ticketid = ticketid;
    }

    public String getOrderTrainname() {
        return orderTrainname;
    }

    public void setOrderTrainname(String orderTrainname) {
        this.orderTrainname = orderTrainname == null ? null : orderTrainname.trim();
    }

    public String getOrderStartstation() {
        return orderStartstation;
    }

    public void setOrderStartstation(String orderStartstation) {
        this.orderStartstation = orderStartstation == null ? null : orderStartstation.trim();
    }

    public String getOrderEndstation() {
        return orderEndstation;
    }

    public void setOrderEndstation(String orderEndstation) {
        this.orderEndstation = orderEndstation == null ? null : orderEndstation.trim();
    }

    public String getOrderStarttime() {
        return orderStarttime;
    }

    public void setOrderStarttime(String orderStarttime) {
        this.orderStarttime = orderStarttime;
    }

    public String getOrderArrivetime() {
        return orderArrivetime;
    }

    public void setOrderArrivetime(String orderArrivetime) {
        this.orderArrivetime = orderArrivetime;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getSeatid() {
        return seatid;
    }

    public void setSeatid(Integer seatid) {
        this.seatid = seatid;
    }

    public Integer getOrderCarriage() {
        return orderCarriage;
    }

    public void setOrderCarriage(Integer orderCarriage) {
        this.orderCarriage = orderCarriage;
    }

    public String getOrderSeattype() {
        return orderSeattype;
    }

    public void setOrderSeattype(String orderSeattype) {
        this.orderSeattype = orderSeattype == null ? null : orderSeattype.trim();
    }

    public String getOrderSeatlocation() {
        return orderSeatlocation;
    }

    public void setOrderSeatlocation(String orderSeatlocation) {
        this.orderSeatlocation = orderSeatlocation == null ? null : orderSeatlocation.trim();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", userid=" + userid +
                ", orderUsername='" + orderUsername + '\'' +
                ", orderIdcardname='" + orderIdcardname + '\'' +
                ", orderIdcardnumber='" + orderIdcardnumber + '\'' +
                ", ticketid=" + ticketid +
                ", orderTrainname='" + orderTrainname + '\'' +
                ", orderStartstation='" + orderStartstation + '\'' +
                ", orderEndstation='" + orderEndstation + '\'' +
                ", orderStarttime=" + orderStarttime +
                ", orderArrivetime=" + orderArrivetime +
                ", orderPrice=" + orderPrice +
                ", ordertime=" + ordertime +
                ", status='" + status + '\'' +
                ", seatid=" + seatid +
                ", orderCarriage=" + orderCarriage +
                ", orderSeattype='" + orderSeattype + '\'' +
                ", orderSeatlocation='" + orderSeatlocation + '\'' +
                '}';
    }
}
package com.gdou.service;

import com.gdou.domain.Seat;

import java.util.List;

/**
 * 座位Service 业务层接口
 */
public interface SeatService {

    /**
     * 获取所有座位信息
     *
     * @return List<Seat> 所有座位
     */
    List<Seat> getAllSeatInfo(Integer offset, Integer limit);


    /**
     * 获取分页总数
     */
    long getTotal();


    /**
     * 新增座位
     *
     * @param seat 新座位信息
     */
    void addSeat(Seat seat);


    /**
     * 删除座位
     *
     * @param seatid 座位id
     * @return true：座位信息删除成功  false：座位信息删除失败
     */
    boolean deleteSeat(Integer seatid);


    /**
     * 搜索座位信息
     *
     * @param value 搜索信息
     * @return List<Seat> 座位列表
     */
    List<Seat> getSeatInfo(String value);
}

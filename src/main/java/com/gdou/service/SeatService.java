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

    /**
     * 根据 列车id 以及 座位类型 以及 座位号 获取 座位信息
     *
     * @param trainid      列车id
     * @param seattype     座位类型
     * @param seatlocation 座位号
     * @return List<Seat>
     */
    List<Seat> getSeatByTrainIdAndSeatTypeAndSeatLocation(Integer trainid, String seattype, String seatlocation);


    /**
     * 根据 座位id 获取 单个座位信息
     *
     * @param seatid 座位id
     * @return Seat 单个座位信息
     */
    Seat getOneSeat(Integer seatid);


    /**
     * 修改座位信息
     *
     * @param seat 新座位信息
     * @return true：修改座位信息成功  false：修改座位信息失败
     */
    boolean updateSeat(Seat seat);
}

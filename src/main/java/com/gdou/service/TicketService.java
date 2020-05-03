package com.gdou.service;

import com.gdou.domain.Ticket;

import java.util.List;

/**
 * 车票Service 业务层接口
 */
public interface TicketService {

    /**
     * 获取所有车票信息
     *
     * @return List<Train> 所有车票信息
     */
    List<Ticket> getAllTicketInfo(Integer offset, Integer limit);


    /**
     * 获取分页总数
     */
    long getTotal();


    /**
     * 新增车票
     *
     * @param ticket 新车票信息
     * @return true：车票信息添加成功  false：车票信息添加失败
     */
    boolean addTicket(Ticket ticket);


    /**
     * 修改车票信息
     *
     * @param ticket 新始车票信息
     * @return true：修改车票信息成功  false：修改车票信息失败
     */
    boolean updateTicket(Ticket ticket);


    /**
     * 删除车票
     *
     * @param ticketid 车票id
     * @return true：车票删除成功  false：车票删除失败
     */
    boolean deleteTicket(Integer ticketid);


    /**
     * 搜索车票台信息
     *
     * @param query_startstation 查询条件 始发站
     * @param query_endstation   查询条件 终点站
     * @param query_starttime    查询条件 发车时间
     * @param query_arrivetime   查询条件 到达时间
     * @return List<Ticket>
     */
    List<Ticket> getTicketInfo(String query_startstation, String query_endstation, String query_starttime, String query_arrivetime);


    /**
     * 用户获取所有车票信息
     *
     * @return List<Ticket>
     */
    List<Ticket> getAllTicketInfoUser();


    /**
     * 根据 列车id 以及 座位类型 获取 座位号
     *
     * @param trainid  列车id
     * @param seattype 座位类型
     * @return List<String>
     */
    List<String> getSeatLocationByTrainIdAndSeatType(Integer trainid, String seattype);


    /**
     * 根据 车票id 获取 单个车票信息
     *
     * @param ticketid 车票id
     * @return Ticket 车票信息
     */
    Ticket getOneTicketInfo(Integer ticketid);


    /**
     * 根据 始发站 和 终点站 获取 车票发车时间
     *
     * @param startstation 始发站
     * @param endstation   终点站
     * @return List<String>
     */
    List<String> getStartTimeByStation(String startstation, String endstation);


    /**
     * 据所选始发站、终点站、发车时间 获取 唯一始终站台信息
     *
     * @param startstation 始发站
     * @param endstation   终点站
     * @param starttime    发车时间
     * @return List<Ticket>
     */
    List<Ticket> getNewTicket(String startstation, String endstation, String starttime);
}

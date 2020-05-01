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
}

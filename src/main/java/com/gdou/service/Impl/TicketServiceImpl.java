package com.gdou.service.Impl;

import com.gdou.domain.Ticket;
import com.gdou.domain.TicketExample;
import com.gdou.mapper.TicketMapper;
import com.gdou.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 车票Service 实现类
 */
@Service
public class TicketServiceImpl implements TicketService {
    //注入TicketMapper
    @Autowired
    private TicketMapper ticketMapper;

    /**
     * 获取所有车票信息
     *
     * @return List<Ticket> 所有车票信息
     */
    @Override
    public List<Ticket> getAllTicketInfo(Integer offset, Integer limit) {
        List<Ticket> tickets = null;
        tickets = ticketMapper.selectAllTicketInfo(offset, limit);
        return tickets;
    }


    /**
     * 获取分页总数
     *
     * @return count 分页总数
     */
    @Override
    public long getTotal() {
        TicketExample example = new TicketExample();
        long count = ticketMapper.countByExample(example);
        return count;
    }


    /**
     * 新增车票
     *
     * @param ticket 新车票信息
     * @return true：车票信息添加成功  false：车票信息添加失败
     */
    @Override
    public boolean addTicket(Ticket ticket) {
        int count = ticketMapper.insert(ticket);
        return count != 0;
    }


    /**
     * 修改车票信息
     *
     * @param ticket 新始车票信息
     * @return true：修改车票信息成功  false：修改车票信息失败
     */
    @Override
    public boolean updateTicket(Ticket ticket) {
        int count = ticketMapper.updateByPrimaryKeySelective(ticket);
        return count != 0;
    }


    /**
     * 删除车票
     *
     * @param ticketid 车票id
     * @return true：车票删除成功  false：车票删除失败
     */
    @Override
    public boolean deleteTicket(Integer ticketid) {
        int count = ticketMapper.deleteByPrimaryKey(ticketid);
        return count != 0;
    }

    /**
     * 搜索车票台信息
     *
     * @param query_startstation 查询条件 始发站
     * @param query_endstation   查询条件 终点站
     * @param query_starttime    查询条件 发车时间
     * @param query_arrivetime   查询条件 到达时间
     * @return List<Ticket>
     */
    @Override
    public List<Ticket> getTicketInfo(String query_startstation, String query_endstation, String query_starttime, String query_arrivetime) {
        TicketExample example = new TicketExample();
        TicketExample.Criteria criteria = example.createCriteria();
        if (!(query_startstation == "" || query_startstation.equals(""))) {
            criteria.andTicketStartstationLike("%" + query_startstation + "%"); //根据始发站模糊查询
        }
        if (!(query_endstation == "" || query_endstation.equals(""))) {
            criteria.andTicketEndstationLike("%" + query_endstation + "%"); //根据终点站模糊查询
        }
        if (!(query_starttime == "" || query_starttime.equals(""))) {
            criteria.andTicketStarttimeGreaterThanOrEqualTo(query_starttime); //根据发车时间查询
        }
        if (!(query_arrivetime == "" || query_arrivetime.equals(""))) {
            criteria.andTicketArrivetimeLessThanOrEqualTo(query_arrivetime); //根据到达时阿查询
        }
        List<Ticket> tickets = null;
        tickets = ticketMapper.selectByExample(example);
        return tickets;
    }


    /**
     * 用户获取所有车票信息
     *
     * @return List<Ticket>
     */
    @Override
    public List<Ticket> getAllTicketInfoUser() {
        TicketExample example = new TicketExample();
        return ticketMapper.selectByExample(example);
    }


    /**
     * 根据 列车id 以及 座位类型 获取 座位号
     *
     * @param trainid  列车id
     * @param seattype 座位类型
     * @return List<String>
     */
    @Override
    public List<String> getSeatLocationByTrainIdAndSeatType(Integer trainid, String seattype) {
        return ticketMapper.selectSeatLocationByTrainIdAndSeatType(trainid, seattype);
    }


    /**
     * 根据 车票id 获取 单个车票信息
     *
     * @param ticketid 车票id
     * @return Ticket 车票信息
     */
    @Override
    public Ticket getOneTicketInfo(Integer ticketid) {
        return ticketMapper.selectByPrimaryKey(ticketid);
    }


    /**
     * 根据 始发站 和 终点站 获取 车票发车时间
     *
     * @param startstation 始发站
     * @param endstation   终点站
     * @return List<String>
     */
    @Override
    public List<String> getStartTimeByStation(String startstation, String endstation) {
        return ticketMapper.selectStartTimeByStation(startstation, endstation);
    }


    /**
     * 据所选始发站、终点站、发车时间 获取 唯一始终站台信息
     *
     * @param startstation 始发站
     * @param endstation   终点站
     * @param starttime    发车时间
     * @return List<Ticket>
     */
    @Override
    public List<Ticket> getNewTicket(String startstation, String endstation, String starttime) {
        TicketExample example = new TicketExample();
        TicketExample.Criteria criteria = example.createCriteria();
        criteria.andTicketStartstationEqualTo(startstation);
        criteria.andTicketEndstationEqualTo(endstation);
        criteria.andTicketStarttimeEqualTo(starttime);
        List<Ticket> tickets = null;
        tickets = ticketMapper.selectByExample(example);
        return tickets;
    }
}

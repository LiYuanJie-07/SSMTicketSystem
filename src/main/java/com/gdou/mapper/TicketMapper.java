package com.gdou.mapper;

import com.gdou.domain.Ticket;
import com.gdou.domain.TicketExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TicketMapper {
    long countByExample(TicketExample example);

    int deleteByExample(TicketExample example);

    int deleteByPrimaryKey(Integer ticketid);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    List<Ticket> selectByExample(TicketExample example);

    Ticket selectByPrimaryKey(Integer ticketid);

    int updateByExampleSelective(@Param("record") Ticket record, @Param("example") TicketExample example);

    int updateByExample(@Param("record") Ticket record, @Param("example") TicketExample example);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);

    //查询所有车票信息
    List<Ticket> selectAllTicketInfo(@Param("offset") Integer offset, @Param("limit") Integer limit);

    //根据 列车id 以及 座位类型 获取 座位号
    List<String> selectSeatLocationByTrainIdAndSeatType(@Param("trainid") Integer trainid, @Param("seattype") String seattype);

}
package com.gdou.mapper;

import com.gdou.domain.Seat;
import com.gdou.domain.SeatExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SeatMapper {
    long countByExample(SeatExample example);

    int deleteByExample(SeatExample example);

    int deleteByPrimaryKey(Integer seatid);

    int insert(Seat record);

    int insertSelective(Seat record);

    List<Seat> selectByExample(SeatExample example);

    Seat selectByPrimaryKey(Integer seatid);

    int updateByExampleSelective(@Param("record") Seat record, @Param("example") SeatExample example);

    int updateByExample(@Param("record") Seat record, @Param("example") SeatExample example);

    int updateByPrimaryKeySelective(Seat record);

    int updateByPrimaryKey(Seat record);

    //查询所有座位信息(包含所属列车)
    List<Seat> selectAllSeatInfo(@Param("offset") Integer offset, @Param("limit") Integer limit);

    //搜索座位信息(包含所属列车)
    List<Seat> searchSeatInfo(@Param("value") String value);
}
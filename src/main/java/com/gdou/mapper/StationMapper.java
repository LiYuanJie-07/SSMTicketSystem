package com.gdou.mapper;

import com.gdou.domain.Station;
import com.gdou.domain.StationExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StationMapper {
    long countByExample(StationExample example);

    int deleteByExample(StationExample example);

    int deleteByPrimaryKey(Integer stationid);

    int insert(Station record);

    int insertSelective(Station record);

    List<Station> selectByExample(StationExample example);

    Station selectByPrimaryKey(Integer stationid);

    int updateByExampleSelective(@Param("record") Station record, @Param("example") StationExample example);

    int updateByExample(@Param("record") Station record, @Param("example") StationExample example);

    int updateByPrimaryKeySelective(Station record);

    int updateByPrimaryKey(Station record);

    //获取所有始发站
    List<String> selectAllStartStation();

    //根据所选始发站获取终点站
    List<String> selectEndStationByStartStation(@Param("startstation") String startstation);

    //根据所选始发站和终点站获取发车时间
    List<String> selectStartTimeByStartAndEnd(@Param("startstation") String startstation, @Param("endstation") String endstation);
}
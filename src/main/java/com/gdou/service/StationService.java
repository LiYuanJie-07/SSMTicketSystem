package com.gdou.service;

import com.gdou.domain.Station;

import java.util.List;

/**
 * 始终站台Service 业务层接口
 */
public interface StationService {

    /**
     * 获取所有始终站台信息
     *
     * @return List<Station> 所有始终站信息
     */
    List<Station> getAllStationInfo();


    /**
     * 新增始终站台信息
     *
     * @param station 始终站台信息
     * @return true：新增始终站台信息成功  false：新增始终站台信息失败
     */
    boolean addStation(Station station);


    /**
     * 修改始终站台信息
     *
     * @param station 新始终站台信息
     * @return true：修改始终站台信息成功  false：修改始终站台信息失败
     */
    boolean updateStation(Station station);


    /**
     * 删除始终站台
     *
     * @param stationid 始终站台id
     * @return true：始终站台信息删除成功  false：始终站台信息删除失败
     */
    boolean deleteStation(Integer stationid);


    /**
     * 搜索始终站台信息
     *
     * @param query_startstation 查询条件 始发站
     * @param query_endstation   查询条件 终点站
     * @param query_starttime    查询条件 发车时间
     * @param query_arrivetime   查询条件 到达时间
     * @return List<Station> 站台信息
     */
    List<Station> getStationInfo(String query_startstation, String query_endstation, String query_starttime, String query_arrivetime);


    /**
     * 获取所有始发站
     *
     * @return List<Map>
     */
    List<String> getAllStartStation();


    /**
     * 根据所选始发站获取终点站
     *
     * @param startstation 始发站
     * @return List<String>
     */
    List<String> getEndStation(String startstation);


    /**
     * 根据所选始发站和终点站获取发车时间
     *
     * @param startstation 始发站
     * @param endstation   终点站
     * @return List<String>
     */
    List<String> getStartTime(String startstation, String endstation);


    /**
     * 据所选始发站、终点站、发车时间 获取 唯一始终站台信息
     *
     * @param startstation 始发站
     * @param endstation   终点站
     * @param starttime    发车时间
     * @return List<Station>
     */
    List<Station> getStationBySelect(String startstation, String endstation, String starttime);
}

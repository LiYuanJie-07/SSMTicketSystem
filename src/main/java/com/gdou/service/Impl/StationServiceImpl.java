package com.gdou.service.Impl;

import com.gdou.domain.Station;
import com.gdou.domain.StationExample;
import com.gdou.mapper.StationMapper;
import com.gdou.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 始终站Service 实现类
 */
@Service
public class StationServiceImpl implements StationService {
    //注入StationMapper
    @Autowired
    private StationMapper stationMapper;

    /**
     * 获取所有始终站台信息
     *
     * @return List<Station> 所有始终站台信息
     */
    @Override
    public List<Station> getAllStationInfo() {
        StationExample example = new StationExample();
        return stationMapper.selectByExample(example);
    }


    /**
     * 新增始终站台信息
     *
     * @param station 始终站台信息
     * @return true：新增始终站台信息成功  false：新增始终站台信息失败
     */
    @Override
    public boolean addStation(Station station) {
        int count = stationMapper.insert(station);
        return count != 0;
    }


    /**
     * 根据id更新站台信息
     *
     * @param station 新始终站台信息
     * @return true：修改始终站台信息成功  false：修改始终站台信息失败
     */
    @Override
    public boolean updateStation(Station station) {
        int count = stationMapper.updateByPrimaryKeySelective(station);
        return count != 0;
    }


    /**
     * 根据id删除始终站台信息
     *
     * @param stationid 始终站台id
     * @return true：始终站台信息删除成功  false：始终站台信息删除失败
     */
    @Override
    public boolean deleteStation(Integer stationid) {
        int count = stationMapper.deleteByPrimaryKey(stationid);
        return count != 0;
    }


    /**
     * 搜索始终站台信息
     *
     * @param query_startstation 查询条件 始发站
     * @param query_endstation   查询条件 终点站
     * @param query_starttime    查询条件 发车时间
     * @param query_arrivetime   查询条件 到达时间
     * @return List<Station> 站台信息
     */
    @Override
    public List<Station> getStationInfo(String query_startstation, String query_endstation, String query_starttime, String query_arrivetime) {
        StationExample example = new StationExample();
        StationExample.Criteria criteria = example.createCriteria();
        if (!(query_startstation == "" || query_startstation.equals(""))) {
            criteria.andStartstationLike("%" + query_startstation + "%"); //根据始发站模糊查询
        }
        if (!(query_endstation == "" || query_endstation.equals(""))) {
            criteria.andEndstationLike("%" + query_endstation + "%"); //根据终点站模糊查询
        }
        if (!(query_starttime == "" || query_starttime.equals(""))) {
            criteria.andStarttimeGreaterThanOrEqualTo(query_starttime); //根据发车时间查询
        }
        if (!(query_arrivetime == "" || query_arrivetime.equals(""))) {
            criteria.andArrivetimeLessThanOrEqualTo(query_arrivetime); //根据到达时阿查询
        }
        List<Station> stations = null;
        stations = stationMapper.selectByExample(example);
        return stations;
    }


    /**
     * 获取所有始发站
     *
     * @return List<Map>
     */
    @Override
    public List<String> getAllStartStation() {
        return stationMapper.selectAllStartStation();
    }


    /**
     * 根据所选始发站获取终点站
     *
     * @param startstation 始发站
     * @return List<String>
     */
    @Override
    public List<String> getEndStation(String startstation) {
        return stationMapper.selectEndStationByStartStation(startstation);
    }


    /**
     * 根据所选始发站和终点站获取发车时间
     *
     * @param startstation 始发站
     * @param endstation   终点站
     * @return List<String>
     */
    @Override
    public List<String> getStartTime(String startstation, String endstation) {
        return stationMapper.selectStartTimeByStartAndEnd(startstation, endstation);
    }


    /**
     * 据所选始发站、终点站、发车时间 获取 唯一始终站台信息
     *
     * @param startstation 始发站
     * @param endstation   终点站
     * @param starttime    发车时间
     * @return List<Station>
     */
    @Override
    public List<Station> getStationBySelect(String startstation, String endstation, String starttime) {
        StationExample example = new StationExample();
        StationExample.Criteria criteria = example.createCriteria();
        criteria.andStartstationEqualTo(startstation);
        criteria.andEndstationEqualTo(endstation);
        criteria.andStarttimeEqualTo(starttime);
        List<Station> stations = null;
        stations = stationMapper.selectByExample(example);
        return stations;
    }
}

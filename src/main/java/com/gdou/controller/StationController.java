package com.gdou.controller;

import com.gdou.domain.Station;
import com.gdou.service.StationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 始终站台Controller
 */
@Controller
@RequestMapping(value = "/stationController")
public class StationController extends BasicController {
    //注入StationService
    @Autowired
    private StationService stationService;

    /**
     * 获取所有始终站台信息
     *
     * @param page 页数
     * @param rows 每页记录条数
     * @return Msg
     */
    @RequestMapping(value = "/getAllStationInfo", method = RequestMethod.GET)
    @ResponseBody
    public Msg getAllStationInfo(Integer page, Integer rows) {
        //使用分页插件,传入页码，每页大小
        PageHelper.startPage(page, rows);
        //startPage后面紧跟的这个查询就是分页查询
        List<Station> allStationInfo = stationService.getAllStationInfo();
        //使用PageInfo包装查询结果
        PageInfo pageInfo = new PageInfo(allStationInfo);
        if (pageInfo == null || pageInfo.getSize() == 0) {
            return Msg.fail("获取始终站台信息失败！");
        } else {
            //包装成EasyUI需要的格式：total：总条数，rows：数据列表
            Map<String, Object> easyUIData = new HashMap<String, Object>();
            easyUIData.put("total", pageInfo.getTotal());
            easyUIData.put("rows", pageInfo.getList());
            return Msg.success("获取始终站台信息成功！").add("allStationInfo", easyUIData);
        }
    }


    /**
     * 新增始终站台
     *
     * @param station 新始终站台信息
     * @return Msg
     */
    @RequestMapping(value = "/addStationInfo", method = RequestMethod.POST)
    @ResponseBody
    public Msg addStationInfo(Station station) {
        //设置预计抵达时间
        station.setArrivetime(this.calTime(station.getStarttime(), station.getUsetime()));
        //新增始终站台
        boolean reg = stationService.addStation(station);
        if (reg) {
            return Msg.success("新的站台已添加！");
        } else {
            return Msg.fail("站台信息添加失败！");
        }
    }


    /**
     * 修改始终站台信息
     *
     * @param station 新始终站台信息
     * @return Msg
     */
    @RequestMapping(value = "/changeStationInfo", method = RequestMethod.POST)
    @ResponseBody
    public Msg changeStationInfo(Station station) {
        //设置预计抵达时间
        station.setArrivetime(this.calTime(station.getStarttime(), station.getUsetime()));
        //修改始终站台信息
        boolean reg = stationService.updateStation(station);
        if (reg) {
            return Msg.success("始终站台信息修改成功！");
        } else {
            return Msg.fail("始终站台信息修改失败！");
        }
    }


    /**
     * 删除始终站台信息
     *
     * @param stationid 始终站台id
     * @return Msg
     */
    @RequestMapping(value = "/deleteStationInfo", method = RequestMethod.GET)
    @ResponseBody
    public Msg deleteStationInfo(Integer stationid) {
        //删除站台
        boolean reg = stationService.deleteStation(stationid);
        if (reg) {
            return Msg.success("站台信息已删除！");
        } else {
            return Msg.fail("站台信息删除失败！");
        }
    }


    /**
     * 搜索始终站台信息
     *
     * @param query_startstation 查询条件 始发站
     * @param query_endstation   查询条件 终点站
     * @param query_starttime    查询条件 发车时间
     * @param query_arrivetime   查询条件 到达时间
     * @return Msg
     */
    @RequestMapping(value = "/searchStationInfo", method = RequestMethod.GET)
    @ResponseBody
    public Msg searchStationInfo(String query_startstation, String query_endstation, String query_starttime, String query_arrivetime) {
        List<Station> stationInfo = stationService.getStationInfo(query_startstation, query_endstation, query_starttime, query_arrivetime);
        if (stationInfo == null || stationInfo.size() == 0) {
            return Msg.fail("没有符合条件的站台信息！");
        } else {
            //包装成EasyUI需要的格式：total：总条数，rows：数据列表
            Map<String, Object> easyUIData = new HashMap<String, Object>();
            easyUIData.put("total", stationInfo.size());
            easyUIData.put("rows", stationInfo);
            return Msg.success("共查找到 " + stationInfo.size() + " 条记录").add("searchStationInfo", easyUIData);
        }
    }


    /**
     * 刷新所有列车日期时间
     *
     * @return Msg
     */
    @RequestMapping(value = "/updateStationTime", method = RequestMethod.GET)
    @ResponseBody
    public Msg updateStationTime() throws ParseException {
        List<Station> allStationInfo = stationService.getAllStationInfo();
        //刷新日期到最新一天
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowDate = new Date(); //当前日期
        for (Station station : allStationInfo) {
            Date stationDate = df.parse(station.getStarttime()); //数据库站台日期
            if (stationDate.before(nowDate)) {//判断数据库站台日期是否小于当前日期
                //计算两个日期间相差的天数，并转换为分钟数
                double timediff = nowDate.getTime() - stationDate.getTime();
                int mindiff = (int) (Math.ceil(timediff / (1000 * 3600 * 24)) * 60 * 24);
                //刷新出发时间
                station.setStarttime(this.calTime(station.getStarttime(), mindiff));
                //刷新到达时间
                station.setArrivetime(this.calTime(station.getStarttime(), station.getUsetime()));
                //更新数据库
                boolean reg = stationService.updateStation(station);
            }
        }
        return Msg.success("站台日期刷新成功！");
    }


    /**
     * 获取所有始发站
     *
     * @return List<Map < String, String>>
     */
    @RequestMapping(value = "/getAllStartStation", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, String>> getAllStartStation() {
        List<String> allStartStation = stationService.getAllStartStation();
        //包装成EasyUI需要的格式：id：选项id，text：选项文本
        List<Map<String, String>> easyUIComboboxList = new ArrayList<>();
        for (int i = 0; i < allStartStation.size(); i++) {
            Map<String, String> easyUIData = new HashMap<String, String>();
            easyUIData.put("id", allStartStation.get(i));
            easyUIData.put("text", allStartStation.get(i));
            easyUIComboboxList.add(easyUIData);
        }
        return easyUIComboboxList;
    }


    /**
     * 根据所选始发站获取终点站
     *
     * @param startstation 始发站
     * @return List<Map < String, String>>
     */
    @RequestMapping(value = "/getEndStation", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, String>> getEndStation(String startstation) {
        List<String> endStations = stationService.getEndStation(startstation);
        //包装成EasyUI需要的格式：id：选项id，text：选项文本
        List<Map<String, String>> easyUIComboboxList = new ArrayList<>();
        for (int i = 0; i < endStations.size(); i++) {
            Map<String, String> easyUIData = new HashMap<String, String>();
            easyUIData.put("id", endStations.get(i));
            easyUIData.put("text", endStations.get(i));
            easyUIComboboxList.add(easyUIData);
        }
        return easyUIComboboxList;
    }


    /**
     * 根据所选始发站和终点站获取发车时间
     *
     * @param startstation 始发站
     * @param endstation   终点站
     * @return List<Map < String, String>>
     */
    @RequestMapping(value = "/getStartTime", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, String>> getStartTime(String startstation, String endstation) {
        List<String> startTime = stationService.getStartTime(startstation, endstation);
        //包装成EasyUI需要的格式：id：选项id，text：选项文本
        List<Map<String, String>> easyUIComboboxList = new ArrayList<>();
        for (int i = 0; i < startTime.size(); i++) {
            Map<String, String> easyUIData = new HashMap<String, String>();
            easyUIData.put("id", startTime.get(i));
            easyUIData.put("text", startTime.get(i));
            easyUIComboboxList.add(easyUIData);
        }
        return easyUIComboboxList;
    }


    /**
     * 据所选始发站、终点站、发车时间 获取 唯一始终站台信息
     *
     * @param startstation 始发站
     * @param endstation   终点站
     * @param starttime    发车时间
     * @return Msg
     */
    @RequestMapping(value = "/getStationBySelect", method = RequestMethod.GET)
    @ResponseBody
    public Msg getStationBySelect(String startstation, String endstation, String starttime) {
        List<Station> stations = stationService.getStationBySelect(startstation, endstation, starttime);
        if (stations == null || stations.size() == 0) {
            return Msg.fail("获取站台信息失败！");
        } else {
            Station station = stations.get(0);
            return Msg.success("获取站台信息成功！").add("station", station);
        }

    }

}


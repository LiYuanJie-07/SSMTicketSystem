package com.gdou.controller;

import com.gdou.domain.Seat;
import com.gdou.domain.Ticket;
import com.gdou.service.SeatService;
import com.gdou.service.TicketService;
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
 * 用户售票大厅Controller
 */
@Controller
@RequestMapping(value = "/userTicketController")
public class UserTicketController extends BasicController {
    //注入TicketService
    @Autowired
    private TicketService ticketService;

    //注入SeatService
    @Autowired
    private SeatService seatService;


    /**
     * 用户获取所有车票信息
     *
     * @param page 页数
     * @param rows 每页记录条数
     * @return Msg
     */
    @RequestMapping(value = "/getAllTicketInfoUser", method = RequestMethod.GET)
    @ResponseBody
    public Msg getAllTicketInfoUser(Integer page, Integer rows) {
        //使用分页插件,传入页码，每页大小
        PageHelper.startPage(page, rows);
        //startPage后面紧跟的这个查询就是分页查询
        List<Ticket> allTicketInfoUser = ticketService.getAllTicketInfoUser();
        //使用PageInfo包装查询结果
        PageInfo pageInfo = new PageInfo(allTicketInfoUser);
        if (pageInfo == null || pageInfo.getSize() == 0) {
            return Msg.fail("获取车票信息失败！");
        } else {
            //包装成EasyUI需要的格式：total：总条数，rows：数据列表
            Map<String, Object> easyUIData = new HashMap<String, Object>();
            easyUIData.put("total", pageInfo.getTotal());
            easyUIData.put("rows", pageInfo.getList());
            return Msg.success("获取车票信息成功！").add("allTicketInfoUser", easyUIData);
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
        List<Ticket> allTicketinfo = ticketService.getAllTicketInfoUser();
        //刷新日期到最新一天
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowDate = new Date(); //当前日期
        for (Ticket ticket : allTicketinfo) {
            Date startDate = df.parse(ticket.getTicketStarttime()); //数据库发车日期
            if (startDate.before(nowDate)) {//判断数据库发车日期是否小于当前日期
                //计算两个日期间相差的天数，并转换为分钟数
                double timediff = nowDate.getTime() - startDate.getTime();
                int mindiff = (int) (Math.ceil(timediff / (1000 * 3600 * 24)) * 60 * 24);
                //刷新出发时间
                ticket.setTicketStarttime(this.calTime(ticket.getTicketStarttime(), mindiff));
                //刷新到达时间
                ticket.setTicketArrivetime(this.calTime(ticket.getTicketStarttime(), ticket.getTicketUsetime()));
                //更新数据库
                boolean reg = ticketService.updateTicket(ticket);
            }
        }
        return Msg.success("站台日期刷新成功！");
    }


    /**
     * 搜索车票信息
     *
     * @param query_startstation 查询条件 始发站
     * @param query_endstation   查询条件 终点站
     * @param query_starttime    查询条件 发车时间
     * @param query_arrivetime   查询条件 到达时间
     * @return Msg
     */
    @RequestMapping(value = "/searchTicketInfo", method = RequestMethod.GET)
    @ResponseBody
    public Msg searchTicketInfo(String query_startstation, String query_endstation, String query_starttime, String query_arrivetime) {
        List<Ticket> tickets = ticketService.getTicketInfo(query_startstation, query_endstation, query_starttime, query_arrivetime);
        if (tickets == null || tickets.size() == 0) {
            return Msg.fail("没有符合条件的车票信息！");
        } else {
            //包装成EasyUI需要的格式：total：总条数，rows：数据列表
            Map<String, Object> easyUIData = new HashMap<String, Object>();
            easyUIData.put("total", tickets.size());
            easyUIData.put("rows", tickets);
            return Msg.success("共查找到 " + tickets.size() + " 条记录").add("searchTicketInfo", easyUIData);
        }
    }


    /**
     * 根据 列车id 以及 座位类型 获取 座位号
     *
     * @param trainid  列车id
     * @param seattype 座位类型
     * @return List<Map < String, String>>
     */
    @RequestMapping(value = "/getSeatLocationByTrainIdAndSeatType", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, String>> getSeatLocationByTrainIdAndSeatType(Integer trainid, String seattype) {
        List<String> seatLocations = ticketService.getSeatLocationByTrainIdAndSeatType(trainid, seattype);
        //包装成EasyUI需要的格式：id：选项id，text：选项文本
        List<Map<String, String>> easyUIComboboxList = new ArrayList<>();
        for (int i = 0; i < seatLocations.size(); i++) {
            Map<String, String> easyUIData = new HashMap<String, String>();
            easyUIData.put("id", seatLocations.get(i));
            easyUIData.put("text", seatLocations.get(i));
            easyUIComboboxList.add(easyUIData);
        }
        return easyUIComboboxList;
    }


    /**
     * 根据 列车id 以及 座位类型 以及 座位号 获取 座位信息
     *
     * @param trainid      列车id
     * @param seattype     座位类型
     * @param seatlocation 座位号
     * @return Msg
     */
    @RequestMapping(value = "/getSeatByTrainIdAndSeatTypeAndSeatLocation", method = RequestMethod.GET)
    @ResponseBody
    public Msg getSeatByTrainIdAndSeatTypeAndSeatLocation(Integer trainid, String seattype, String seatlocation) {
        List<Seat> seats = seatService.getSeatByTrainIdAndSeatTypeAndSeatLocation(trainid, seattype, seatlocation);
        if (seats == null || seats.size() == 0) {
            return Msg.fail("获取座位信息失败！");
        } else {
            return Msg.success("获取座位信息成功！").add("seat", seats.get(0));
        }
    }

}

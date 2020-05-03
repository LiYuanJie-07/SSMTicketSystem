package com.gdou.controller;

import com.gdou.domain.Ticket;
import com.gdou.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 票务管理Controller
 */
@Controller
@RequestMapping(value = "/ticketController")
public class TicketController extends BasicController {
    //注入TicketService
    @Autowired
    private TicketService ticketService;


    /**
     * 获取所有车票信息
     *
     * @param page 页数
     * @param rows 每页记录条数
     * @return Msg
     */
    @RequestMapping(value = "/getAllTicketInfo", method = RequestMethod.GET)
    @ResponseBody
    public Msg getAllTicketInfo(Integer page, Integer rows) {
        List<Ticket> allTicketInfo = ticketService.getAllTicketInfo((page - 1) * rows, rows);
        long count = ticketService.getTotal();
        if (allTicketInfo == null || allTicketInfo.size() == 0) {
            return Msg.fail("获取所有车票信息失败！");
        } else {
            //包装成EasyUI需要的格式：total：总条数，rows：数据列表
            Map<String, Object> easyUIData = new HashMap<String, Object>();
            easyUIData.put("total", count);
            easyUIData.put("rows", allTicketInfo);
            return Msg.success("获取所有车票信息成功！").add("allTicketInfo", easyUIData);
        }
    }


    /**
     * 新增车票
     *
     * @param ticket 新车票信息
     * @return Msg
     */
    @RequestMapping(value = "/addTicketInfo", method = RequestMethod.POST)
    @ResponseBody
    public Msg addTicketInfo(Ticket ticket) {
        //新增车票
        boolean reg = ticketService.addTicket(ticket);
        if (reg) {
            return Msg.success("新的车票信息已添加！");
        } else {
            return Msg.fail("车票信息添加失败！");
        }
    }

    /**
     * 删除车票
     *
     * @param ticketid 车票id
     * @return Msg
     */
    @RequestMapping(value = "/deleteTicketInfo", method = RequestMethod.GET)
    @ResponseBody
    public Msg deleteTicketInfo(Integer ticketid) {
        //删除车票
        boolean reg = ticketService.deleteTicket(ticketid);
        if (reg) {
            return Msg.success("车票信息已删除！");
        } else {
            return Msg.fail("车票信息删除失败！");
        }
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
     * 根据 始发站 和 终点站 获取 车票发车时间
     *
     * @param startstation 始发站
     * @param endstation   终点站
     * @return List<Map < String, String>>
     */
    @RequestMapping(value = "/getStartTimeByStation", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, String>> getStartTimeByStation(String startstation, String endstation) {
        List<String> startTime = ticketService.getStartTimeByStation(startstation, endstation);
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
     * 据所选始发站、终点站、发车时间 获取 唯一新车票（用于改签操作）
     *
     * @param startstation 始发站
     * @param endstation   终点站
     * @param starttime    发车时间
     * @return Msg
     */
    @RequestMapping(value = "/getNewTicket", method = RequestMethod.GET)
    @ResponseBody
    public Msg getNewTicket(String startstation, String endstation, String starttime) {
        List<Ticket> tickets = ticketService.getNewTicket(startstation, endstation, starttime);
        if (tickets == null || tickets.size() == 0) {
            return Msg.fail("获取新车票信息失败！");
        } else {
            Ticket ticket = tickets.get(0);
            return Msg.success("获取新车票信息成功！").add("ticket", ticket);
        }

    }

}

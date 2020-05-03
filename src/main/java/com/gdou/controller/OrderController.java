package com.gdou.controller;

import com.gdou.domain.*;
import com.gdou.service.OrderService;
import com.gdou.service.SeatService;
import com.gdou.service.TicketService;
import com.gdou.service.TrainService;
import com.gdou.utils.ExcelUtil;
import com.gdou.utils.QRCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单Controller
 */
@Controller
@RequestMapping(value = "/orderController")
public class OrderController extends BasicController {
    //注入OrderService
    @Autowired
    private OrderService orderService;

    //注入TicketService
    @Autowired
    private TicketService ticketService;

    //注入TrainService
    @Autowired
    private TrainService trainService;

    //注入SeatService
    @Autowired
    private SeatService seatService;


    /**
     * 购票
     * 1.新增订单
     * 2.更新车票表车票数量
     * 3.更新列车表座位数量
     * 4.设置座位状态为已选
     *
     * @param order 订单信息
     * @return Msg
     */
    @RequestMapping(value = "/addOrderInfo", method = RequestMethod.POST)
    @ResponseBody
    public Msg addOrderInfo(Order order, HttpServletRequest request) {
        //获取session
        HttpSession session = request.getSession();
        //获取session中的user对象
        User user = (User) session.getAttribute("user");
        // 1.新增订单
        //设置orderid、userid、orderUsername、orderIdcardname、orderIdcardnumber、ordertime、status
        order.setOrderid(this.createSerial());
        order.setUserid(user.getUserid());
        order.setOrderUsername(user.getUsername());
        order.setOrderIdcardname(user.getIdcardname());
        order.setOrderIdcardnumber(user.getIdcardnumber());
        order.setOrdertime(this.getDateTime());
        order.setStatus("已支付");
        boolean addOrder = orderService.addOrderInfo(order);
        // 2.更新车票表车票数量 3.更新列车表座位数量
        Ticket ticket = ticketService.getOneTicketInfo(order.getTicketid());
        Train train = trainService.getOneTrain(ticket.getTrainid());
        if (order.getOrderSeattype().equals("商务座")) {
            ticket.setSpecialSeatNumber(ticket.getSpecialSeatNumber() - 1);
            train.setSpecialClassSeat(train.getSpecialClassSeat() - 1);
        } else if (order.getOrderSeattype().equals("一等座")) {
            ticket.setFirstSeatNumber(ticket.getFirstSeatNumber() - 1);
            train.setFirstClassSeat(train.getFirstClassSeat() - 1);
        } else {
            ticket.setSecondSeatNumber(ticket.getSecondSeatNumber() - 1);
            train.setSecondClassSeat(train.getSecondClassSeat() - 1);
        }
        boolean updateTicketSeatNum = ticketService.updateTicket(ticket);
        boolean updateTrainSeatNum = trainService.updateTrain(train);
        // 4.设置座位状态为已选（1）
        Seat seat = seatService.getOneSeat(order.getSeatid());
        seat.setStatus(1);
        boolean updateSeat = seatService.updateSeat(seat);
        if (addOrder && updateTicketSeatNum && updateTrainSeatNum && updateSeat) {
            return Msg.success("购票成功！");
        } else {
            return Msg.fail("购票失败！");
        }

    }


    /**
     * 根据用户id获取所有订单
     *
     * @param page 页数
     * @param rows 每页记录条数
     * @return Msg
     */
    @RequestMapping(value = "/getAllOrderInfo", method = RequestMethod.GET)
    @ResponseBody
    public Msg getAllOrderInfo(Integer page, Integer rows, HttpServletRequest request) throws ParseException {
        //获取session
        HttpSession session = request.getSession();
        //获取session中的user对象
        User user = (User) session.getAttribute("user");
        List<Order> allOrderInfo = orderService.getAllOrderInfo((page - 1) * rows, rows, user.getUserid());
        if (allOrderInfo == null || allOrderInfo.size() == 0) {
            return Msg.fail("暂无订单信息，快去买票吧！");
        } else {
            /**
             * 检查订单是否过期，如已过期则
             * 1.更新status
             * 2.更新车票表车票数量
             * 3.更新列车表座位数量
             * 4.设置座位状态为未选
             */
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date nowDate = new Date(); //当前日期
            for (Order order : allOrderInfo) {
                Date orderArriveTime = df.parse(order.getOrderArrivetime()); //数据库订单中的 预计到达时间
                if (nowDate.after(orderArriveTime)) {//当前时间大于列车到达时间 则 已过期
                    // 1.更新status
                    order.setStatus("已过期");
                    orderService.updateOrder(order);
                    // 2.更新车票表车票数量 3.更新列车表座位数量
                    Ticket ticket = ticketService.getOneTicketInfo(order.getTicketid());
                    Train train = trainService.getOneTrain(ticket.getTrainid());
                    if (order.getOrderSeattype().equals("商务座")) {
                        ticket.setSpecialSeatNumber(ticket.getSpecialSeatNumber() + 1);
                        train.setSpecialClassSeat(train.getSpecialClassSeat() + 1);
                    } else if (order.getOrderSeattype().equals("一等座")) {
                        ticket.setFirstSeatNumber(ticket.getFirstSeatNumber() + 1);
                        train.setFirstClassSeat(train.getFirstClassSeat() + 1);
                    } else {
                        ticket.setSecondSeatNumber(ticket.getSecondSeatNumber() + 1);
                        train.setSecondClassSeat(train.getSecondClassSeat() + 1);
                    }
                    ticketService.updateTicket(ticket);
                    trainService.updateTrain(train);
                    // 4.设置座位状态为未选（0）
                    Seat seat = seatService.getOneSeat(order.getSeatid());
                    seat.setStatus(0);
                    seatService.updateSeat(seat);
                }
            }
            //包装成EasyUI需要的格式：total：总条数，rows：数据列表
            Map<String, Object> easyUIData = new HashMap<String, Object>();
            easyUIData.put("total", allOrderInfo.size());
            easyUIData.put("rows", allOrderInfo);
            return Msg.success("获取订单信息成功！").add("allOrderInfo", easyUIData);
        }
    }


    /**
     * 删除订单（修改status）
     *
     * @param orderid 订单号
     * @return Msg
     */
    @RequestMapping(value = "/deleteOrderInfo", method = RequestMethod.GET)
    @ResponseBody
    public Msg deleteOrder(String orderid, String status) {
        /**
         * 检查订单status是否为已支付，若为已支付
         * 1.更新车票表车票数量
         * 2.更新列车表座位数量
         * 3.设置座位状态为未选
         */
        if (status.equals("已支付")) {
            // 1.更新车票表车票数量 2.更新列车表座位数量
            Order order = orderService.getOneOrderInfo(orderid);
            Ticket ticket = ticketService.getOneTicketInfo(order.getTicketid());
            Train train = trainService.getOneTrain(ticket.getTrainid());
            if (order.getOrderSeattype().equals("商务座")) {
                ticket.setSpecialSeatNumber(ticket.getSpecialSeatNumber() + 1);
                train.setSpecialClassSeat(train.getSpecialClassSeat() + 1);
            } else if (order.getOrderSeattype().equals("一等座")) {
                ticket.setFirstSeatNumber(ticket.getFirstSeatNumber() + 1);
                train.setFirstClassSeat(train.getFirstClassSeat() + 1);
            } else {
                ticket.setSecondSeatNumber(ticket.getSecondSeatNumber() + 1);
                train.setSecondClassSeat(train.getSecondClassSeat() + 1);
            }
            ticketService.updateTicket(ticket);
            trainService.updateTrain(train);
            // 3.设置座位状态为未选（0）
            Seat seat = seatService.getOneSeat(order.getSeatid());
            seat.setStatus(0);
            seatService.updateSeat(seat);
        }
        //修改status为已删除
        boolean reg = orderService.deleteOrderInfo(orderid);
        if (reg) {
            return Msg.success("订单记录已删除！");
        } else {
            return Msg.fail("订单记录删除失败！");
        }
    }


    /**
     * 退票
     *
     * @param orderid 订单号
     * @return Msg
     */
    @RequestMapping(value = "/returnOrder", method = RequestMethod.POST)
    @ResponseBody
    public Msg returnOrder(String orderid) {
        // 1.更新车票表车票数量 2.更新列车表座位数量
        Order order = orderService.getOneOrderInfo(orderid);
        Ticket ticket = ticketService.getOneTicketInfo(order.getTicketid());
        Train train = trainService.getOneTrain(ticket.getTrainid());
        if (order.getOrderSeattype().equals("商务座")) {
            ticket.setSpecialSeatNumber(ticket.getSpecialSeatNumber() + 1);
            train.setSpecialClassSeat(train.getSpecialClassSeat() + 1);
        } else if (order.getOrderSeattype().equals("一等座")) {
            ticket.setFirstSeatNumber(ticket.getFirstSeatNumber() + 1);
            train.setFirstClassSeat(train.getFirstClassSeat() + 1);
        } else {
            ticket.setSecondSeatNumber(ticket.getSecondSeatNumber() + 1);
            train.setSecondClassSeat(train.getSecondClassSeat() + 1);
        }
        ticketService.updateTicket(ticket);
        trainService.updateTrain(train);
        // 3.设置座位状态为未选（0）
        Seat seat = seatService.getOneSeat(order.getSeatid());
        seat.setStatus(0);
        seatService.updateSeat(seat);

        //修改status为 已退票
        order.setStatus("已退票");
        //退票
        boolean reg = orderService.updateOrder(order);
        if (reg) {
            return Msg.success("退票办理成功！");
        } else {
            return Msg.fail("退票办理失败！");
        }
    }


    /**
     * 改签
     *
     * @param orderid     订单号
     * @param newTicketId 改签车票id
     * @return Msg
     */
    @RequestMapping(value = "/exchangeOrderInfo", method = RequestMethod.POST)
    @ResponseBody
    public Msg exchangeOrderInfo(String orderid, Integer newTicketId) {
        // 1.获取订单、旧车票、新车票
        Order order = orderService.getOneOrderInfo(orderid);  //订单信息
        Ticket oldTicket = ticketService.getOneTicketInfo(order.getTicketid()); //订单中的原车票信息
        Ticket newTicket = ticketService.getOneTicketInfo(newTicketId); //改签的车票信息
        // 2.更新订单信息
        order.setTicketid(newTicket.getTicketid());
        order.setOrderStarttime(newTicket.getTicketStarttime());
        order.setOrderArrivetime(newTicket.getTicketArrivetime());
        order.setOrdertime(this.getDateTime());
        boolean orderReg = orderService.updateOrder(order);
        // 3.更新新旧车票数量
        if (order.getOrderSeattype().equals("商务座")) {
            oldTicket.setSpecialSeatNumber(oldTicket.getSpecialSeatNumber() + 1);
            newTicket.setSpecialSeatNumber(newTicket.getSpecialSeatNumber() - 1);
        } else if (order.getOrderSeattype().equals("一等座")) {
            oldTicket.setFirstSeatNumber(oldTicket.getFirstSeatNumber() + 1);
            newTicket.setFirstSeatNumber(newTicket.getFirstSeatNumber() - 1);
        } else {
            oldTicket.setSecondSeatNumber(oldTicket.getSecondSeatNumber() + 1);
            newTicket.setSecondSeatNumber(newTicket.getSecondSeatNumber() - 1);
        }
        boolean oldTicketReg = ticketService.updateTicket(oldTicket);
        boolean newTicketReg = ticketService.updateTicket(newTicket);

        if (orderReg && oldTicketReg && newTicketReg) {
            return Msg.success("改签办理成功！");
        } else {
            return Msg.fail("改签办理失败！");
        }
    }


    /**
     * 查看详细（根据订单id获取订单信息，并生成二维码）
     *
     * @param orderid 订单号
     * @return Msg
     */
    @RequestMapping(value = "/getOrderDetails", method = RequestMethod.GET)
    @ResponseBody
    public Msg getOrderDetails(String orderid, HttpServletRequest request) throws Exception {
        Order order = orderService.getOneOrderInfo(orderid);
        //二维码内容
        String content = "订单信息" + '\n' +
                "订单号：" + order.getOrderid() + '\n' +
                "订单状态：" + order.getStatus() + '\n' +
                "用户ID：" + order.getUserid() +
                "   用户名：" + order.getOrderUsername() + '\n' +
                "姓名：" + order.getOrderIdcardname() + '\n' +
                "身份证号：" + order.getOrderIdcardnumber() + '\n' +
                "车票ID：" + order.getTicketid() +
                "   车次：" + order.getOrderTrainname() + '\n' +
                "始发站：" + order.getOrderStartstation() +
                "   终点站：" + order.getOrderEndstation() + '\n' +
                "发车时间：" + order.getOrderStarttime() + '\n' +
                "预计到达时间：" + order.getOrderArrivetime() + '\n' +
                "订单金额：" + order.getOrderPrice() + "元" + '\n' +
                "下单时间：" + order.getOrdertime() + '\n' +
                "座位ID：" + order.getSeatid() +
                "   座位类型：" + order.getOrderSeattype() + '\n' +
                "车厢：" + order.getOrderCarriage() + "号" +
                "   座位号：" + order.getOrderSeatlocation();
        String rootPath = request.getSession().getServletContext().getRealPath("/"); // 部署后的项目根路径
        // 二维码存放路径
        String destPath = rootPath + "/ssmTicketSystem/static/images/qrcode/" + order.getOrderUsername() + "/" + order.getOrderid() + ".jpg";
        // logo路径
        String logoPath = rootPath + "/ssmTicketSystem/static/images/12306.jpg";
        QRCodeUtil.encode(content, logoPath, destPath);
        return Msg.success("订单详细获取成功！").add("orderDetails", order);
    }


    /**
     * 打印车票
     *
     * @param request
     * @param response
     * @param orderid
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/downLoadOrder", method = RequestMethod.GET)
    @ResponseBody
    public Msg exportExcel(HttpServletRequest request, HttpServletResponse response, String orderid) throws IOException {
        Order order = orderService.getOneOrderInfo(orderid);
        String rootPath = request.getSession().getServletContext().getRealPath("/"); // 部署后的项目根路径
        String filename = order.getOrderid() + ".xls";

        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        ExcelUtil.createExcel(response.getOutputStream(), rootPath, order);
        return Msg.success("订单已打印！");
    }

}

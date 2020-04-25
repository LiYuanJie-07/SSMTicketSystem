package com.gdou.controller;

import com.gdou.domain.Seat;
import com.gdou.domain.Train;
import com.gdou.service.SeatService;
import com.gdou.service.TrainService;
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
 * 座位管理Controller
 */
@Controller
@RequestMapping(value = "/seatController")
public class SeatController extends BasicController {
    //注入SeatService
    @Autowired
    private SeatService seatService;

    //注入TrainService
    @Autowired
    private TrainService trainService;

    /**
     * 获取所有座位信息
     *
     * @param page 页数
     * @param rows 每页记录条数
     * @return Msg
     */
    @RequestMapping(value = "/getAllSeatInfo", method = RequestMethod.GET)
    @ResponseBody
    public Msg getAllSeatInfo(Integer page, Integer rows) {
        List<Seat> allSeatInfo = seatService.getAllSeatInfo((page - 1) * rows, rows);
        long count = seatService.getTotal();
        if (allSeatInfo == null || allSeatInfo.size() == 0) {
            return Msg.fail("获取所有座位信息失败！");
        } else {
            //包装成EasyUI需要的格式：total：总条数，rows：数据列表
            Map<String, Object> easyUIData = new HashMap<String, Object>();
            easyUIData.put("total", count);
            easyUIData.put("rows", allSeatInfo);
            return Msg.success("获取所有座位信息成功！").add("allSeatInfo", easyUIData);
        }
    }


    /**
     * 获取座位所属列车
     *
     * @return List<Map> 座位所属列车
     */
    @RequestMapping(value = "/getTrainOfSeat", method = RequestMethod.GET)
    @ResponseBody
    public List<Map> getTrainOfSeat() {
        List<Train> trains = trainService.getAllTrainInfo();
        //包装成EasyUI需要的格式：id：选项id，text：选项文本
        List<Map> easyUIComboboxList = new ArrayList<>();
        for (Train train : trains) {
            Map<String, Object> easyUIData = new HashMap<String, Object>();
            easyUIData.put("id", train.getTrainid());
            easyUIData.put("text", train.getTrainname());
            easyUIComboboxList.add(easyUIData);
        }
        return easyUIComboboxList;
    }


    /**
     * 新增座位
     *
     * @param seat   新座位信息
     * @param number 新增座位数量
     * @return Msg
     */
    @RequestMapping(value = "/addSeatInfo", method = RequestMethod.POST)
    @ResponseBody
    public Msg addSeatInfo(Seat seat, Integer number) {
        seat.setStatus(0); // 设置座位未售出
        char seatTypeCode = seat.getSeattype().equals("商务座") ? 'S' : (seat.getSeattype().equals("一等座") ? 'Y' : 'E');
        char seatLocationCode = 'A';
        String seatlocation = seatTypeCode + String.valueOf(seat.getTrainid()) + String.valueOf(seat.getCarriage());
        for (int i = 1; i <= number; i++) {
            seat.setSeatlocation(seatlocation + seatLocationCode); //设置座位号
            seatLocationCode++;
            //新增座位
            seatService.addSeat(seat);
        }
        //更新列车座位数量
        Train train = trainService.getOneTrain(seat.getTrainid());
        if (seat.getSeattype().equals("商务座")) {
            train.setSpecialClassSeat(train.getSpecialClassSeat() + number);
        } else if (seat.getSeattype().equals("一等座")) {
            train.setFirstClassSeat(train.getFirstClassSeat() + number);
        } else {
            train.setSecondClassSeat(train.getSecondClassSeat() + number);
        }
        boolean reg = trainService.updateTrain(train);
        if (reg) {
            return Msg.success("新的座位已添加！");
        } else {
            return Msg.fail("座位信息添加失败！");
        }
    }


    /**
     * 删除座位
     *
     * @param seatid 座位id
     * @return Msg
     */
    @RequestMapping(value = "/deleteSeatInfo", method = RequestMethod.GET)
    @ResponseBody
    public Msg deleteSeatInfo(Integer seatid, Integer trainid, String seattype) {
        //删除座位
        boolean regSeat = seatService.deleteSeat(seatid);
        //更新列车座位数量
        Train train = trainService.getOneTrain(trainid);
        if (seattype.equals("商务座")) {
            train.setSpecialClassSeat(train.getSpecialClassSeat() - 1);
        } else if (seattype.equals("一等座")) {
            train.setFirstClassSeat(train.getFirstClassSeat() - 1);
        } else {
            train.setSecondClassSeat(train.getSecondClassSeat() - 1);
        }
        boolean regTrain = trainService.updateTrain(train);
        if (regSeat && regTrain) {
            return Msg.success("座位信息已删除！");
        } else {
            return Msg.fail("座位信息删除失败！");
        }
    }


    /**
     * 搜索座位信息
     *
     * @param value 搜索内容
     * @return Msg
     */
    @RequestMapping(value = "/searchSeatInfo", method = RequestMethod.GET)
    @ResponseBody
    public Msg searchSeatInfo(String value) {
        List<Seat> seatInfo = seatService.getSeatInfo(value);
        if (seatInfo == null || seatInfo.size() == 0) {
            return Msg.fail("没有该座位信息！");
        } else {
            //包装成EasyUI需要的格式：total：总条数，rows：数据列表
            Map<String, Object> easyUIData = new HashMap<String, Object>();
            easyUIData.put("total", seatInfo.size());
            easyUIData.put("rows", seatInfo);
            return Msg.success("共查找到 " + seatInfo.size() + " 条记录").add("searchSeatInfo", easyUIData);
        }
    }


}

package com.gdou.controller;

import com.gdou.domain.Train;
import com.gdou.service.TrainService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * 列车管理Controller
 */
@Controller
@RequestMapping(value = "/trainController")
public class TrainController extends BasicController {
    //注入TrainService
    @Autowired
    private TrainService trainService;

    /**
     * 获取所有列车信息
     *
     * @param page 页数
     * @param rows 每页记录条数
     * @return Msg
     */
    @RequestMapping(value = "/getAllTrainInfo", method = RequestMethod.GET)
    @ResponseBody
    public Msg getAllTrainInfo(Integer page, Integer rows) {
        //使用分页插件,传入页码，每页大小
        PageHelper.startPage(page, rows);
        //startPage后面紧跟的这个查询就是分页查询
        List<Train> allTrainInfo = trainService.getAllTrainInfo();
        //使用PageInfo包装查询结果
        PageInfo pageInfo = new PageInfo(allTrainInfo);
        if (pageInfo == null || pageInfo.getSize() == 0) {
            return Msg.fail("获取列车信息失败！");
        } else {
            //包装成EasyUI需要的格式：total：总条数，rows：数据列表
            Map<String, Object> easyUIData = new HashMap<String, Object>();
            easyUIData.put("total", pageInfo.getTotal());
            easyUIData.put("rows", pageInfo.getList());
            return Msg.success("获取列车信息成功！").add("allTrainInfo", easyUIData);
        }
    }


    /**
     * 获取列车初始站点
     *
     * @return Msg
     */
    @RequestMapping(value = "/getTrainLocation", method = RequestMethod.GET)
    @ResponseBody
    public List<Map> getTrainLocation() {
        List<String> allTrainLocation = trainService.getAllTrainLocation();
        //包装成EasyUI需要的格式：id：选项id，text：选项文本
        List<Map> easyUIComboboxList = new ArrayList<>();
        for (int i = 0; i < allTrainLocation.size(); i++) {
            Map<String, Object> easyUIData = new HashMap<String, Object>();
            easyUIData.put("id", allTrainLocation.get(i));
            easyUIData.put("text", allTrainLocation.get(i));
            easyUIComboboxList.add(easyUIData);
        }
        return easyUIComboboxList;
    }


    /**
     * 新增列车
     *
     * @param train 新列车信息
     * @return Msg
     */
    @RequestMapping(value = "/addTrainInfo", method = RequestMethod.POST)
    @ResponseBody
    public Msg addTrainInfo(Train train) {
        //设置座位数量
        train.setSpecialClassSeat(5);
        train.setFirstClassSeat(10);
        train.setSecondClassSeat(10);
        //新增列车
        boolean reg = trainService.addTrain(train);
        if (reg) {
            return Msg.success("新的列车已添加！");
        } else {
            return Msg.fail("列车添加失败！");
        }
    }


    /**
     * 修改列车信息
     *
     * @param train 新列车信息
     * @return Msg
     */
    @RequestMapping(value = "/changeTrainInfo", method = RequestMethod.POST)
    @ResponseBody
    public Msg changeTrainInfo(Train train) {
        System.out.println(train);
        //修改列车信息
        boolean reg = trainService.updateTrain(train);
        if (reg) {
            return Msg.success("列车信息修改成功！");
        } else {
            return Msg.fail("列车信息修改失败！");
        }
    }


    /**
     * 删除列车
     *
     * @param trainid 列车id
     * @return Msg
     */
    @RequestMapping(value = "/deleteTrainInfo", method = RequestMethod.GET)
    @ResponseBody
    public Msg deleteTrainInfo(Integer trainid) {
        //删除列车
        boolean reg = trainService.deleteTrain(trainid);
        if (reg) {
            return Msg.success("列车信息已删除！");
        } else {
            return Msg.fail("列车信息删除失败！");
        }
    }


    /**
     * 搜索列车信息
     *
     * @param value 搜索内容
     * @return Msg
     */
    @RequestMapping(value = "/searchTrainInfo", method = RequestMethod.GET)
    @ResponseBody
    public Msg searchTrainInfo(String value) {
        List<Train> trainInfo = trainService.getTrainInfo(value);
        if (trainInfo == null || trainInfo.size() == 0) {
            return Msg.fail("没有该列车信息！");
        } else {
            //包装成EasyUI需要的格式：total：总条数，rows：数据列表
            Map<String, Object> easyUIData = new HashMap<String, Object>();
            easyUIData.put("total", trainInfo.size());
            easyUIData.put("rows", trainInfo);
            return Msg.success("共查找到 " + trainInfo.size() + " 条记录").add("searchTrainInfo", easyUIData);
        }
    }

}

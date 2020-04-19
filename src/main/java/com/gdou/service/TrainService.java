package com.gdou.service;

import com.gdou.domain.Train;

import java.util.List;

/**
 * 火车Service 业务层接口
 */
public interface TrainService {

    /**
     * 获取所有列车信息
     *
     * @return List<Train> 所有列车信息
     */
    List<Train> getAllTrainInfo();


    /**
     * 获取所有的列车初始站
     *
     * @return List<String> 所有的初始站名
     */
    List<String> getAllTrainLocation();


    /**
     * 新增列车
     *
     * @param train 新列车信息
     * @return true：新增列车成功  false：新增列车失败
     */
    boolean addTrain(Train train);


    /**
     * 修改列车信息
     *
     * @param train 新列车信息
     * @return true：修改列车信息成功  false：修改列车信息失败
     */
    boolean updateTrain(Train train);


    /**
     * 删除列车
     *
     * @param trainid 列车id
     * @return true：列车信息删除成功  false：列车信息删除失败
     */
    boolean deleteTrain(Integer trainid);


    /**
     * 搜索列车信息
     *
     * @param value 搜索信息
     * @return List<Train>
     */
    List<Train> getTrainInfo(String value);
}

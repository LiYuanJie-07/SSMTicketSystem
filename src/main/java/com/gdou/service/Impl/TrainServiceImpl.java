package com.gdou.service.Impl;

import com.gdou.domain.Train;
import com.gdou.domain.TrainExample;
import com.gdou.mapper.TrainMapper;
import com.gdou.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 火车Service 实现类
 */
@Service
public class TrainServiceImpl implements TrainService {
    //注入TrainMapper
    @Autowired
    private TrainMapper trainMapper;

    /**
     * 获取所有列车信息
     *
     * @return List<Train> 所有列车信息
     */
    @Override
    public List<Train> getAllTrainInfo() {
        TrainExample example = new TrainExample();
        return trainMapper.selectByExample(example);
    }


    /**
     * 根据列车id获取单个列车信息
     *
     * @param trainid 列车id
     * @return train 单个列车信息
     */
    @Override
    public Train getOneTrain(Integer trainid) {
        Train train = trainMapper.selectByPrimaryKey(trainid);
        return train;
    }


    /**
     * 获取所有的列车初始站
     *
     * @return List<String> 所有的初始站名
     */
    @Override
    public List<String> getAllTrainLocation() {
        List<String> allTrainLocation = null;
        allTrainLocation = trainMapper.selectAllTrainLocation();
        return allTrainLocation;
    }


    /**
     * 新增列车
     *
     * @param train 新列车信息
     * @return true：新增列车成功  false：新增列车失败
     */
    @Override
    public boolean addTrain(Train train) {
        int count = trainMapper.insert(train);
        return count != 0;
    }


    /**
     * 根据id更新列车信息
     *
     * @param train 新列车信息
     * @return true：修改列车信息成功  false：修改列车信息失败
     */
    @Override
    public boolean updateTrain(Train train) {
        int count = trainMapper.updateByPrimaryKeySelective(train);
        return count != 0;
    }


    /**
     * 根据id删除列车信息
     *
     * @param trainid 列车id
     * @return true：列车信息删除成功  false：列车信息删除失败
     */
    @Override
    public boolean deleteTrain(Integer trainid) {
        int count = trainMapper.deleteByPrimaryKey(trainid);
        return count != 0;
    }


    /**
     * 搜索列车信息
     *
     * @param value 搜索信息
     * @return List<Train>
     */
    @Override
    public List<Train> getTrainInfo(String value) {
        TrainExample example = new TrainExample();
        example.or().andTrainnameLike("%" + value + "%"); //根据列车名模糊查询
        example.or().andTraintypeLike("%" + value + "%"); //根据列车类型模糊查询
        example.or().andTrainlocationLike("%" + value + "%"); //根据初始站模糊查询
        List<Train> trains = null;
        trains = trainMapper.selectByExample(example);
        return trains;
    }
}

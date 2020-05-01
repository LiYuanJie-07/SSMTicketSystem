package com.gdou.mapper;

import com.gdou.domain.Train;
import com.gdou.domain.TrainExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TrainMapper {
    long countByExample(TrainExample example);

    int deleteByExample(TrainExample example);

    int deleteByPrimaryKey(Integer trainid);

    int insert(Train record);

    int insertSelective(Train record);

    List<Train> selectByExample(TrainExample example);

    Train selectByPrimaryKey(Integer trainid);

    int updateByExampleSelective(@Param("record") Train record, @Param("example") TrainExample example);

    int updateByExample(@Param("record") Train record, @Param("example") TrainExample example);

    int updateByPrimaryKeySelective(Train record);

    int updateByPrimaryKey(Train record);

    //获取所有的列车初始站
    List<String> selectAllTrainLocation();

    //根据 始发站 以及 列车类型 获取 车次（列车名）
    List<String> selectTrainNameByLocationAndTrainType(@Param("trainlocation") String trainlocation, @Param("traintype") String traintype);
}
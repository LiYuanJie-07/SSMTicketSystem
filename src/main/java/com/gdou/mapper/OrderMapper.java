package com.gdou.mapper;

import com.gdou.domain.Order;
import com.gdou.domain.OrderExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String orderid);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String orderid);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //根据用户id获取所有订单
    List<Order> selectAllOrderInfo(@Param("offset") Integer offset, @Param("limit") Integer limit, @Param("userid") Integer userid);

    //删除订单（修改status）
    int deleteOrderInfo(@Param("orderid") String orderid);
}
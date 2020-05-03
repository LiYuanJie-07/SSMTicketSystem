package com.gdou.service.Impl;

import com.gdou.domain.Order;
import com.gdou.mapper.OrderMapper;
import com.gdou.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单Service 实现类
 */
@Service
public class OrderServiceImpl implements OrderService {
    //注入OrderMapper
    @Autowired
    private OrderMapper orderMapper;


    /**
     * 新增订单
     *
     * @param order 订单信息
     * @return true：新增订单成功  false：新增订单失败
     */
    @Override
    public boolean addOrderInfo(Order order) {
        int count = orderMapper.insert(order);
        return count != 0;
    }


    /**
     * 根据用户id获取所有订单
     *
     * @return List<Order>
     */
    @Override
    public List<Order> getAllOrderInfo(Integer offset, Integer limit, Integer userid) {
        List<Order> orders = null;
        orders = orderMapper.selectAllOrderInfo(offset, limit, userid);
        return orders;
    }


    /**
     * 修改订单信息
     *
     * @param order 新订单信息
     * @return true：修改订单信息成功  false：修改订单信息失败
     */
    @Override
    public boolean updateOrder(Order order) {
        int count = orderMapper.updateByPrimaryKeySelective(order);
        return count != 0;
    }


    /**
     * 删除订单（修改status）
     *
     * @param orderid 订单号
     * @return true：删除订单信息成功  false：删除订单信息失败
     */
    @Override
    public boolean deleteOrderInfo(String orderid) {
        int count = orderMapper.deleteOrderInfo(orderid);
        return count != 0;
    }


    /**
     * 根据 订单id 获取 单个订单信息
     *
     * @param orderid 订单id
     * @return Order 订单信息
     */
    @Override
    public Order getOneOrderInfo(String orderid) {
        return orderMapper.selectByPrimaryKey(orderid);
    }

}

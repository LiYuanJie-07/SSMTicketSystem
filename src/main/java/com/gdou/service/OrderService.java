package com.gdou.service;

import com.gdou.domain.Order;

import java.util.List;

/**
 * 订单Service 业务层接口
 */
public interface OrderService {

    /**
     * 新增订单
     *
     * @param order 订单信息
     * @return true：新增订单成功  false：新增订单失败
     */
    boolean addOrderInfo(Order order);


    /**
     * 根据用户id获取所有订单（分页）
     *
     * @return List<Order>
     */
    List<Order> getAllOrderInfo(Integer offset, Integer limit, Integer userid);


    /**
     * 修改订单信息
     *
     * @param order 新订单信息
     * @return true：修改订单信息成功  false：修改订单信息失败
     */
    boolean updateOrder(Order order);


    /**
     * 删除订单（修改status）
     *
     * @param orderid 订单号
     * @return true：删除订单信息成功  false：删除订单信息失败
     */
    boolean deleteOrderInfo(String orderid);


    /**
     * 根据 订单id 获取 单个订单信息
     *
     * @param orderid 订单id
     * @return Order 订单信息
     */
    Order getOneOrderInfo(String orderid);

}

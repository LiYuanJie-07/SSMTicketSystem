package com.gdou.service.Impl;

import com.gdou.domain.Seat;
import com.gdou.domain.SeatExample;
import com.gdou.mapper.SeatMapper;
import com.gdou.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 座位Service 实现类
 */
@Service
public class SeatServiceImpl implements SeatService {
    //注入SeatMapper
    @Autowired
    private SeatMapper seatMapper;


    /**
     * 获取所有座位信息
     *
     * @return List<Seat> 所有座位信息
     */
    @Override
    public List<Seat> getAllSeatInfo(Integer offset, Integer limit) {
        List<Seat> seats = null;
        seats = seatMapper.selectAllSeatInfo(offset, limit);
        return seats;
    }


    /**
     * 获取分页总数
     *
     * @return count 分页总数
     */
    @Override
    public long getTotal() {
        SeatExample example = new SeatExample();
        long count = seatMapper.countByExample(example);
        return count;
    }


    /**
     * 新增座位
     *
     * @param seat 新座位信息
     */
    @Override
    public void addSeat(Seat seat) {
        seatMapper.insert(seat);
    }


    /**
     * 根据id删除座位信息
     *
     * @param seatid 座位id
     * @return true：座位信息删除成功  false：座位信息删除失败
     */
    @Override
    public boolean deleteSeat(Integer seatid) {
        int count = seatMapper.deleteByPrimaryKey(seatid);
        return count != 0;
    }


    /**
     * 搜索座位信息
     *
     * @param value 搜索内容
     * @return List<Seat> 符合搜索的座位列表
     */
    @Override
    public List<Seat> getSeatInfo(String value) {
        List<Seat> seats = null;
        value = "%" + value + "%";
        seats = seatMapper.searchSeatInfo(value);
        return seats;
    }
}

package com.gdou.mapper;

import com.gdou.domain.User;
import com.gdou.domain.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 用户Mapper接口
 */
public interface UserMapper {
    //查询所有用户总数
    long countByExample(UserExample example);

    //删除用户
    int deleteByExample(UserExample example);

    //根据id删除用户
    int deleteByPrimaryKey(Integer userid);

    //新增用户（全部字段都有值）
    int insert(User record);

    //新增用户（只有部分字段有值）
    int insertSelective(User record);

    //查询用户
    List<User> selectByExample(UserExample example);

    //根据id查询用户
    User selectByPrimaryKey(Integer userid);

    //更新用户信息（部分字段）
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    //更新用户信息（全部字段，没有值的置为null）
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    //根据主键更新用户信息（部分字段）
    int updateByPrimaryKeySelective(User record);

    //根据主键更新用户信息（全部字段，没有值的置为null）
    int updateByPrimaryKey(User record);
}
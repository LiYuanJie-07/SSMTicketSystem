package com.gdou.mapper;

import com.gdou.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 用户Mapper
 */
public interface UserMapper {
    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return User
     */
    User getUserByUserNameAndPassword(@Param("username")String username,@Param("password")String password);
}

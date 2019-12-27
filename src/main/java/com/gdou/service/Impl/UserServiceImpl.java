package com.gdou.service.Impl;

import com.gdou.domain.User;
import com.gdou.mapper.UserMapper;
import com.gdou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户Service实现类
 */
@Service
public class UserServiceImpl implements UserService {
    //注入UserMapper
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return User
     */
    @Override
    public User getUserByUserNameAndPassword(String username, String password) {
        return userMapper.getUserByUserNameAndPassword(username,password);
    }
}

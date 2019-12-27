package com.gdou.service;

import com.gdou.domain.User;

/**
 * 用户Service  业务层接口
 */
public interface UserService {

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return User
     */
    User getUserByUserNameAndPassword(String username,String password);
}

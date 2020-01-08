package com.gdou.service;

import com.gdou.domain.User;

import java.util.List;

/**
 * 用户Service  业务层接口
 */
public interface UserService {

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     */
    User getUserByUserNameAndPassword(String username, String password);

    /**
     * 更新最近一次登录时间
     * @param user
     */
    void updateLoginTime(User user);

}

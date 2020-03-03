package com.gdou.service.Impl;

import com.gdou.domain.User;
import com.gdou.domain.UserExample;
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
     * 根据用户名/邮箱/手机和密码查询用户
     * @param username
     * @param password
     * @return User
     */
    @Override
    public User getUserByUserNameOrEamilOrPhoneAndPassword(String username, String password) {
        User user = null;
        user = userMapper.getUserByUserNameOrEamilOrPhoneAndPassword(username,password);
        return user;
    }

    /**
     * 根据用户id更新最近一次登陆时间
     * @param user
     */
    @Override
    public void updateLoginTime(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 校验注册用户名是否已经存在
     * @param username
     * @return true：当前用户名可用   false：当前用户名不可用
     */
    @Override
    public boolean checkUsername(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        long count = userMapper.countByExample(example);
        return count == 0;
    }

    /**
     * 用户注册
     * @param user
     * @return true：注册成功 false：注册失败
     */
    @Override
    public boolean addUser(User user) {
        int count = userMapper.insertSelective(user);
        return count != 0;
    }


}

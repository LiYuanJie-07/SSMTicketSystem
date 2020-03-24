package com.gdou.service.Impl;

import com.gdou.domain.User;
import com.gdou.domain.UserExample;
import com.gdou.mapper.UserMapper;
import com.gdou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户Service实现类
 */
@Service
public class UserServiceImpl implements UserService {
    //注入UserMapper
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名/邮箱/手机号查询用户
     *
     * @param username 用户名/邮箱/手机号
     * @return User
     */
    @Override
    public User getUserByUserNameOrEamilOrPhone(String username) {
        UserExample example = new UserExample();
        example.or().andUsernameEqualTo(username);
        example.or().andEmailEqualTo(username);
        example.or().andPhoneEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        User user = null;
        if (users != null && users.size() != 0) {
            user = users.get(0);
        }
        return user;
    }

    /**
     * 根据用户id更新最近一次登陆时间
     *
     * @param user 用户信息
     */
    @Override
    public void updateLoginTime(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 校验注册用户名是否已经存在
     *
     * @param username 用户名
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
     *
     * @param user 用户信息
     * @return true：注册成功 false：注册失败
     */
    @Override
    public boolean addUser(User user) {
        int count = userMapper.insertSelective(user);
        return count != 0;
    }


    /**
     * 密码重置
     *
     * @param user 用户信息
     * @return true：秘密啊修改成功 false：密码修改失败
     */
    @Override
    public boolean changePassword(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(user.getEmail());
        int count = userMapper.updateByExampleSelective(user,example);
        return count != 0;
    }


}

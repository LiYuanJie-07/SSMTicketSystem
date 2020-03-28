package com.gdou.service;

import com.gdou.domain.User;


/**
 * 用户Service  业务层接口
 */
public interface UserService {

    /**
     * 根据用户名/邮箱/手机查询用户
     *
     * @param username 用户名/邮箱/手机号
     */
    User getUserByUserNameOrEamilOrPhone(String username);

    /**
     * 根据id更新用户信息
     *
     * @param user 用户信息
     * @return true：用户信息更新成功 false：用户信息更新失败
     */
    boolean updateUser(User user);

    /**
     * 校验注册用户名是否已经存在
     *
     * @param username 用户名
     * @return true：当前用户名可用   false：当前用户名不可用
     */
    boolean checkUsername(String username);

    /**
     * 用户注册
     *
     * @param user 用户信息
     * @return true：注册成功 false：注册失败
     */
    boolean addUser(User user);

    /**
     * 密码重置
     *
     * @param user 用户信息
     * @return true：秘密啊修改成功 false：密码修改失败
     */
    boolean changePassword(User user);
}
package com.gdou.service.Impl;

import com.gdou.domain.Menu;
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
     * 根据id更新用户信息
     *
     * @param user 用户信息
     * @return true：用户信息更新成功 false：用户信息更新失败
     */
    @Override
    public boolean updateUser(User user) {
        int count = userMapper.updateByPrimaryKeySelective(user);
        return count != 0;
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
        int count = userMapper.updateByExampleSelective(user, example);
        return count != 0;
    }


    /**
     * 获取菜单
     *
     * @param admin 是否管理员
     * @return 菜单列表
     */
    @Override
    public List<Menu> getMenu(Integer admin) {
        List<Menu> menus = userMapper.getMenu(admin);
        return menus;
    }


    /**
     * 查询所有用户信息
     *
     * @return List<User>
     */
    @Override
    public List<User> getAllUserInfo() {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }


    /**
     * 删除用户
     *
     * @param userid 用户id
     * @return true：用户删除成功 false：用户删除失败
     */
    @Override
    public boolean deleteUser(Integer userid) {
        int count = userMapper.deleteByPrimaryKey(userid);
        return count != 0;
    }


    /**
     * 搜索用户
     *
     * @param value 搜索信息
     * @return List<User>
     */
    @Override
    public List<User> getUserInfo(String value) {
        UserExample example = new UserExample();
        example.or().andUsernameLike("%" + value + "%"); //根据用户名模糊查询
        example.or().andEmailEqualTo(value); //根据邮箱查询
        example.or().andIdcardnameLike("%" + value + "%"); //根据姓名模糊查询
        example.or().andIdcardnumberEqualTo(value); //根据身份证号码查询
        example.or().andPhoneEqualTo(value); //根据手机号码查询
        List<User> users = null;
        users = userMapper.selectByExample(example);
        return users;
    }


}

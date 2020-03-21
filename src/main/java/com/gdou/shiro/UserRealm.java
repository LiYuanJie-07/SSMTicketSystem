package com.gdou.shiro;

import com.gdou.domain.User;
import com.gdou.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 登录Realm
 */
public class UserRealm extends AuthenticatingRealm {

    //注入UserService
    @Autowired
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /** 1.把AuthenticationToken 强转为 UsernamePasswordToken **/
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        /** 2.从UsernamePasswordToken 中获取username **/
        String username = token.getUsername();

        /** 3.从数据库中查询username对应用户记录 **/
        User user = userService.getUserByUserNameOrEamilOrPhone(username);

        /** 4.若用户不存在，则抛出用户不存在异常UnknownAccountException **/
        if (user == null) {//判断用户是否存在
            //用户不存在,抛出UnknownAccountException
            throw new UnknownAccountException();
        }
        /** 5.根据用户的情况构建AuthenticationInfo对象并返回,通常使用的实现类为 SimpleAuthenticationInfo **/
        //5.1 参数都是从数据库获取的数据 参数1：用户名 参数2：密码 参数3：realmName
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());

        return info;
    }

}

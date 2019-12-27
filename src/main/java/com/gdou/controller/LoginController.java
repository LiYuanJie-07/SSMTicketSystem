package com.gdou.controller;

import com.gdou.domain.User;
import com.gdou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 登录Controller
 */
@Controller
public class LoginController extends BasicController{
    //注入UserService
    @Autowired
    private UserService userService;

    public void login(){
        String s = this.md5("123456");

        User user = userService.getUserByUserNameAndPassword("admin",s);

        System.out.println(user.getUsername()+"   "+user.getPassword());
    }


}

package com.gdou.controller;

import com.gdou.domain.User;
import com.gdou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录Controller
 */
@Controller
@RequestMapping("/loginController")
public class LoginController extends BasicController{
    //注入UserService
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public void login(String username,String password){
        String s = this.md5("123456");

        User user = userService.getUserByUserNameAndPassword("admin",s);

        System.out.println(user.getUsername()+"   "+user.getPassword());
    }


}

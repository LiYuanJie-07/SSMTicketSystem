package com.gdou.controller;

import com.gdou.domain.User;
import com.gdou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 登录Controller
 */
@Controller
@RequestMapping("/loginController")
public class LoginController extends BasicController{
    //注入UserService
    @Autowired
    private UserService userService;

    /**
     * 登录方法
     * @param username
     * @param password
     */
    @RequestMapping("/login")
    public void login(String username,String password){
        String s = this.md5("123456");

        List<User> users = userService.getUserByUserNameAndPassword("admin",s);
        User user = null;
        if (users != null){
            user = users.get(0);
        }

        System.out.println(user.getUsername()+"   "+user.getPassword());
    }


}

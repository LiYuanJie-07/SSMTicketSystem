package com.gdou.controller;

import com.gdou.domain.User;
import com.gdou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录Controller
 */
@Controller
@RequestMapping("/loginController")
public class LoginController extends BasicController {
    //注入UserService
    @Autowired
    private UserService userService;

    /**
     * 登录方法
     *
     * @param username
     * @param password
     * @param request
     * @return Msg
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Msg login(String username, String password, HttpServletRequest request) {
        //根据用户名和密码查询用户
        String md5Password = this.md5(password);
        User user = userService.getUserByUserNameAndPassword(username, md5Password);
        //获取session
        HttpSession session = request.getSession();

        //判断用户是否存在
        if (user == null) {
            //用户不存在,返回提示信息
            return Msg.fail("用户名或密码错误");
        } else {
            //用户存在
            //更新最近一次登录时间
            String loginTime = this.getDate();
            user.setLogintime(loginTime);
            userService.updateLoginTime(user);
            //把用户信息存入session
            session.setAttribute("user", user);
            //返回提示信息
            return Msg.success("登陆成功");
        }

    }


}

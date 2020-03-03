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
        //根据用户名/邮箱/手机和密码查询用户
        String md5Password = this.md5(password);
        User user = userService.getUserByUserNameOrEamilOrPhoneAndPassword(username, md5Password);
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

    /**
     * 校验注册用户名是否已经存在（已经被注册）
     * @param username
     * @return Msg
     */
    @RequestMapping(value = "/checkUsername", method = RequestMethod.POST)
    @ResponseBody
    public Msg checkUsernameIsExist(String username){
        boolean exist = userService.checkUsername(username);
        if (exist){
            return Msg.success("用户名可用");
        }else{
            return Msg.fail("用户名已存在");
        }
    }

    /**
     * 用户注册方法
     * @param user
     * @return Msg
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Msg register(User user){
        user.setPassword(this.md5(user.getPassword()));
        user.setAdmin(0);
        boolean reg = userService.addUser(user);
        if (reg) {
            return Msg.success("注册成功");
        }else {
            return Msg.fail("注册失败，请重新注册");
        }

    }


}

package com.gdou.controller;

import com.gdou.domain.User;
import com.gdou.service.UserService;
import com.gdou.utils.SendMailUtil;
import com.gdou.utils.VerifyCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户信息操作Controller
 */
@Controller
@RequestMapping(value = "/userController")
public class UserController extends BasicController {
    //注入UserService
    @Autowired
    private UserService userService;

    /**
     * 发送验证码方法
     *
     * @param toEmailAddress 收件邮箱
     * @return Msg
     */
    @RequestMapping(value = "/sendVfyCode", method = RequestMethod.POST)
    @ResponseBody
    public Msg sendVfyCode(String toEmailAddress) {
        String verifyCode = null;
        try {
            //生成6位验证码
            verifyCode = VerifyCodeUtil.generateVerifyCode(6);
            //邮件标题
            String emailTitle = "【云端购票系统】邮箱验证";
            //邮件内容
            String emailContent = "您正在【云端购票系统】进行邮箱验证，您的验证码为：<strong><font color='red'>" + verifyCode + "</font></strong>";
            //发送时间
            String sendTime = this.getDateTime();
            //发送邮件
            SendMailUtil.sendMail(toEmailAddress, emailTitle, emailContent, sendTime);
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.fail("验证码发送失败！" + e.toString());
        }
        return Msg.success("验证码已发送！").add("vfycode", verifyCode);
    }


    /**
     * 密码重置
     *
     * @param user 用户信息
     * @return Msg
     */
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    @ResponseBody
    public Msg changePassword(User user) {
        user.setPassword(this.md5(user.getPassword()));
        boolean reg = userService.changePassword(user);
        if (reg) {
            return Msg.success("密码修改成功，即将跳转到登录页！");
        } else {
            return Msg.fail("密码修改失败，即将刷新本页面！");
        }
    }


}

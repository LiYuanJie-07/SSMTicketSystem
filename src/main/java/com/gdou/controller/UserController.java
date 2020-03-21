package com.gdou.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户信息操作Controller
 */
@Controller
@RequestMapping(value = "/userController")
public class UserController {
    //注入UserService
//    @Autowired
//    private UserService userService;

    /**
     * 发送验证码方法
     *
     * @param toEmailAddress 收件邮箱
     * @return Msg
     */
    @RequestMapping(value = "/sendVfyCode", method = RequestMethod.GET)
    @ResponseBody
    public Msg sendVfyCode(String toEmailAddress) {
//        try {
//            System.out.println("1");
//            //生成6位验证码

//            System.out.println("3");

//        System.out.println(verifyCode);
//            System.out.println("2");
//            //邮件主题
//            String emailTitle = "【云端购票系统】邮箱验证";
//
//            //邮件内容
//            String emailContent = "您正在【云端购票系统】进行邮箱验证，您的验证码为：<strong>" + verifyCode + "</strong>";
//
//            //发送时间
//            String sendTime = this.getDate();
//            //发送邮件
//            SendMailUtil.sendMail("626816858@qq.com", emailTitle, emailContent, sendTime);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }
}

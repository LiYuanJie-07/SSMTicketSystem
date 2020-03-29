package com.gdou.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 父控制器，用于抽取公共代码
 */
@Controller
public class BasicController {

    private Logger log = Logger.getLogger(BasicController.class);

    /**
     * JSON格式响应请求
     * 把数据以JSON格式返回客户端
     */
    public void writeJson(String json, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setContentType("text/html;charset=utf-8");
            out = response.getWriter();
            out.print(json);
            out.flush();
            out.close();
        } catch (Exception e) {
            if (out != null) {
                out.close();
            }
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw, true));
        }

    }

    /**
     * 判断页面是否过期
     *
     * @param request 客户端请求
     * @return boolean true:页面过期, false:页面没过期
     */
    public boolean sessionTimeout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 获取当前日期时间，把当前日期时间按照一定格式返回
     *
     * @return 当前日期时间
     */
    public String getDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = null;
        dateTime = df.format(new Date());
        return dateTime;
    }


    /**
     * 获取当前日期，把当前日期按照一定格式返回
     *
     * @return 当前日期
     */
    public String getDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = null;
        date = df.format(new Date());
        return date;
    }


    /**
     * MD5加密算法 实现对密码加密
     */
    public String md5(String str) {
        if (str == null) {
            return "";
        }
        //获取摘要工具
        MessageDigest m = null;
        try {
            //MD5摘要工具
            m = MessageDigest.getInstance("MD5");
            //更新被文摘描述的位元组
            m.update(str.getBytes("UTF8"));
        }//捕获不支持摘要异常
        catch (NoSuchAlgorithmException e) {
            //创建一个MD5消息文摘的时候出错
            e.printStackTrace();
        }//捕获不支持字符集异常
        catch (UnsupportedEncodingException e) {
            // 更新被文摘描述的位元组的时候出错
            e.printStackTrace();
        }
        // 最后更新使用位元组的被叙述的排列,然后完成文摘计算
        byte s[] = m.digest();
        // 创建结果字符串缓冲
        StringBuilder result = new StringBuilder("");
        //遍历文摘
        for (int i = 0; i < s.length; i++) {
            //进行十六进制转换
            result.append(Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6));
        }
        //返回加密结果
        return result.toString();
    }

    /**
     * 将富文本转换为HTML
     *
     * @param oldStr 富文本
     * @return String
     */
    public String TextToHtml(String oldStr) {
        oldStr = oldStr.replace("&nbsp;", "   ");
        oldStr = oldStr.replace("<", "&lt;");
        oldStr = oldStr.replace(">", "&gt;");
        oldStr = oldStr.replace("\n", "<br/>");
        oldStr = oldStr.replace("\t", "&nbsp;&nbsp;&nbsp;");
        oldStr = oldStr.replace("\"", "&quot;");
        return oldStr;
    }

}

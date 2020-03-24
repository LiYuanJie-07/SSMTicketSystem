package com.gdou.utils;


import com.sun.mail.util.MailSSLSocketFactory;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 发送邮件工具类
 */
public class SendMailUtil {
    //邮件服务器主机名
    private static String myEmailSMTPHost = "smtp.yeah.net";

    //发件人邮箱
    private static String myEmailAccount = "aki_sora@yeah.net";

    //发件人邮箱授权码
    private static String myEmailPassword = "CUJKMQRTWMPXAFVE";

    /**
     * 发送邮件方法
     *
     * @param toEmailAddress 收件人邮箱地址
     * @param emailTitle     邮件标题
     * @param emailContent   邮件内容
     * @throws Exception
     */
    public static void sendMail(String toEmailAddress, String emailTitle, String emailContent, String sendTime) throws Exception {
        /** 1.创建参数配置, 用于连接邮件服务器的参数配置 **/
        Properties props = new Properties();

        // 请求认证，发送服务器需要身份验证，指定验证为true
        props.setProperty("mail.smtp.auth", "true");

        // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.transport.protocol", "smtp");

        // 发件人的邮箱的 smtp 服务器地址
        props.setProperty("mail.smtp.host", myEmailSMTPHost);

        // 开启SSL认证
        MailSSLSocketFactory mailSSLSocketFactory = new MailSSLSocketFactory();
        mailSSLSocketFactory.setTrustAllHosts(true);
        // 设置是否使用ssl安全连接（一般都使用）
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", mailSSLSocketFactory);

        // 创建验证器
        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                // 参数 用户名 授权码
                return new PasswordAuthentication(myEmailAccount, myEmailPassword);
            }
        };

        /** 2.创建一个程序与邮件服务器会话对象 session **/
        Session session = Session.getInstance(props, auth);

        /** 3.创建一个Message，邮件内容 **/
        Message message = new MimeMessage(session);
        //设置邮件标题
        message.setSubject(emailTitle);

        //设置发件人邮箱
        // InternetAddress 的三个参数分别为: 发件人邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
        message.setFrom(new InternetAddress(myEmailAccount, "云端购票系统", "UTF-8"));

        // 设置发送方式与接收者
        message.setRecipient(RecipientType.TO, new InternetAddress(toEmailAddress));

        /** 4.设置邮件内容 **/
        //使用StringBuilder，因为StringBuilder加载速度会比String快，而且线程安全性也不错
        StringBuilder builder = new StringBuilder();

        //写入内容
        builder.append("<br/>尊敬的用户：您好！<br/>" + emailContent +
                "<br/>如果您没有做相关操作，可能是他人误填了您的邮箱地址，请忽略此邮件。<br/>注：本邮件为系统自动发出，请勿回复。");

        //在内容后加入邮件发送的时间
        builder.append("<br/>时间：" + sendTime);

        //设置显示的发件时间
        message.setSentDate(new Date());

        //设置邮件内容
        message.setContent(builder.toString(), "text/html;charset=utf-8");

        /** 5.创建 Transport用于将邮件发送 **/
        Transport.send(message);
    }

}

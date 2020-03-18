<%--
Created by IntelliJ IDEA.
User: YuanJie Li
Date: 2019/02/21
Time: 15:04
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--  Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/ssmTicketSystem/static/css/bootstrap.min.css">

    <link rel="stylesheet" href="/ssmTicketSystem/pages/login/css/login.css">

    <title>登录</title>
</head>

<body>
<div class="container">
    <!-- 登录面板 -->
    <div class="form-signin">
        <div class="header">
            Welcome
        </div>
        <div class="login-title">
            用户登录
        </div>
        <hr/>
        <form id="login-form" method="POST">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="用户名/邮箱/手机号" name="username"
                       id="login-username">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                <span class="help-block" id="login-username-tips"></span>
            </div>
            <div class="form-group  has-feedback">
                <input type="password" class="form-control" placeholder="密码" name="password" id="login-password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                <span class="help-block" id="login-password-tips"></span>
            </div>
            <!-- 登陆按钮 -->
            <button class="btn btn-l pull-right" id="btn-login">
                <span id="login-span">登 录</span>
                <!-- loading动画效果-->
                <div class="sk-wave hide">
                    <div class="sk-wave-rect"></div>
                    <div class="sk-wave-rect"></div>
                    <div class="sk-wave-rect"></div>
                    <div class="sk-wave-rect"></div>
                    <div class="sk-wave-rect"></div>
                </div>
            </button>
            <!-- 注册按钮 -->
            <button class="btn btn-r pull-right" id="btn-goregister">注 册</button>
            <!-- 忘记密码 -->
            <p class="pull-right text-muted goforget">忘记密码？请点 <a href="/index.jsp" class="navbar-link">这里</a>
            </p>
        </form>
    </div>


    <!-- 注册面板 -->
    <div class="reg-form-box" style="display: none;">
        <div class="row">
            <div class="reg-form-box-title">
                <h3>用户注册</h3>
                <p class="text-muted">已有账号？<a href="" class="navbar-link">去登陆</a></p>
            </div>
        </div>
        <div class="row">
            <div class="reg-form-box-main col-sm-12 col-sm-offset-1">
                <form class="form-horizontal" id="register-form" method="POST">
                    <div class="form-group">
                        <label class="col-xs-4 col-sm-3 control-label"><span class="red-star">*</span>用户名：</label>
                        <div class="col-xs-7 col-sm-6">
                            <input type="text" class="form-control" placeholder="请输入用户名" name="username"
                                   id="register-username">
                        </div>
                        <span class="help-block" id="register-username-tips" style="color: darkred;"></span>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 col-sm-3 control-label"><span class="red-star">*</span>登陆密码：</label>
                        <div class="col-xs-7 col-sm-6">
                            <input type="text" class="form-control" placeholder="密码是6-12位数字或字母"
                                   id="register-password1">
                        </div>
                        <span class="help-block" id="register-password1-tips" style="color: darkred;"></span>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 col-sm-3 control-label"><span class="red-star">*</span>确认密码：</label>
                        <div class="col-xs-7 col-sm-6">
                            <input type="text" class="form-control" placeholder="再次输入您的登陆密码" name="password"
                                   id="register-password2">
                        </div>
                        <span class="help-block" id="register-password2-tips" style="color: darkred;"></span>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 col-sm-3 control-label"><span class="red-star">*</span>邮箱：</label>
                        <div class="col-xs-7 col-sm-6">
                            <input type="text" class="form-control" placeholder="请输入邮箱" name="email"
                                   id="register-email">
                        </div>
                        <span class="help-block" id="register-email-tips" style="color: darkred;"></span>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 col-sm-3 control-label"><span class="red-star">*</span>姓名：</label>
                        <div class="col-xs-7 col-sm-6">
                            <input type="text" class="form-control" placeholder="请输入真实姓名" name="idcardname"
                                   id="register-idcardname">
                        </div>
                        <span class="help-block" id="register-idcardname-tips" style="color: darkred;"></span>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 col-sm-3 control-label"><span class="red-star">*</span>身份证号码：</label>
                        <div class="col-xs-7 col-sm-6">
                            <input type="text" class="form-control" placeholder="请输入身份证号码" name="idcardnumber"
                                   id="register-idcardnumber">
                        </div>
                        <span class="help-block" id="register-idcardnumber-tips" style="color: darkred;"></span>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 col-sm-3 control-label"><span class="red-star">*</span>手机号：</label>
                        <div class="col-xs-7 col-sm-6">
                            <input type="text" class="form-control" placeholder="请输入11位手机号" name="phone"
                                   id="register-phone">
                        </div>
                        <span class="help-block" id="register-phone-tips" style="color: darkred;"></span>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-4 col-sm-3 control-label"><span class="red-star">*</span>旅客类型：</label>
                        <div class="col-xs-7 col-sm-8">
                            <select class="InstitutionTypeCode" id="register-type" name="type">
                                <option style='display: none'></option>
                                <option value="成人">成人</option>
                                <option value="儿童">儿童</option>
                                <option value="军人">军人</option>
                                <option value="残疾患者">残疾患者</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-7 col-sm-6 col-sm-offset-3 col-xs-offset-3">
                            <button type="button" class="btn btn-success col-xs-12 col-sm-12 btnok"
                                    id="btn-register">确定
                            </button>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>

</div>

<!-- 提示信息 -->
<div class="alert alert-danger" role="alert" id="tips" style="display:none;">
    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
    <strong id="tips-msg"></strong>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/ssmTicketSystem/static/js/jquery-3.4.1.min.js"></script>

<!--  Bootstrap 核心 JavaScript 文件 -->
<script src="/ssmTicketSystem/static/js/bootstrap.min.js"></script>

<script src="/ssmTicketSystem/pages/login/js/login.js"></script>
</body>

</html>
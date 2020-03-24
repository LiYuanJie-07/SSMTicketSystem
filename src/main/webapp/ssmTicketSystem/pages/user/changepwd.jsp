<%--
  Created by IntelliJ IDEA.
  User: qin
  Date: 2020/3/22
  Time: 23:06
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

    <link rel="stylesheet" href="/ssmTicketSystem/pages/user/css/changepwd.css">

    <title>修改密码</title>
</head>

<body>
<div class="container">
    <!-- 验证邮箱面板 -->
    <div class="checkemail" id="checkemail-panel">
        <div class="header">
            密码重置
        </div>
        <div class="checkemail-title">
            邮箱验证
        </div>
        <hr/>
        <form>
            <div class="form-group has-feedback">
                <input type="email" class="form-control" placeholder="请输入您的注册邮箱" value="${sessionScope.user.email}"
                       id="changepwd-email">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                <span class="help-block" id="changepwd-email-tips"></span>
            </div>
        </form>
        <form class="form-inline">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="6位验证码" name="code" id="changepwd-code">
                <span class="glyphicon glyphicon-edit form-control-feedback"></span>
            </div>
            <!-- 获取验证码按钮 -->
            <button class="btn btn-get btn-info pull-right" id="btn-getcode">
                <span>获取验证码</span>
            </button>
        </form>

        <!-- 下一步按钮 -->
        <button class="btn btn-next btn-success" id="btn-next">
            <strong>Next </strong>
            <span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
            <!-- loading动画效果-->
            <div class="sk-wave hide">
                <div class="sk-wave-rect"></div>
                <div class="sk-wave-rect"></div>
                <div class="sk-wave-rect"></div>
                <div class="sk-wave-rect"></div>
                <div class="sk-wave-rect"></div>
            </div>
        </button>
    </div>
    <!-- /验证邮箱面板 -->


    <!-- 修改密码面板 -->
    <div class="checkemail" id="changepwd-panel" style="display: none;">
        <div class="header">
            密码重置
        </div>
        <div class="checkemail-title">
            修改密码
        </div>
        <hr/>
        <form>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="请输入您的新密码" id="changepwd-password1">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                <span class="help-block" id="changepwd-password1-tips"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="确认新密码" id="changepwd-password2">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                <span class="help-block" id="changepwd-password2-tips"></span>
            </div>
        </form>

        <!-- 确定按钮 -->
        <button class="btn btn-success" id="btn-changepwd">
            <strong>确定</strong>
            <!-- loading动画效果-->
            <div class="sk-wave hide">
                <div class="sk-wave-rect"></div>
                <div class="sk-wave-rect"></div>
                <div class="sk-wave-rect"></div>
                <div class="sk-wave-rect"></div>
                <div class="sk-wave-rect"></div>
            </div>
        </button>
    </div>
    <!-- /修改密码邮箱面板 -->
</div>

<!-- 提示信息 -->
<div class="alert" role="alert" id="tips" style="display: none;">
    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
    <strong id="tips-msg"></strong>
</div>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/ssmTicketSystem/static/js/jquery-3.4.1.min.js"></script>

<!--  Bootstrap 核心 JavaScript 文件 -->
<script src="/ssmTicketSystem/static/js/bootstrap.min.js"></script>

<script src="/ssmTicketSystem/pages/user/js/changepwd.js"></script>
</body>

</html>

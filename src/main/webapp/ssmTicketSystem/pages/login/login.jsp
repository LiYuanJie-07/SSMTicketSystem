<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--  Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/ssmTicketSystem/static/css/bootstrap.css">

    <link rel="stylesheet" href="/ssmTicketSystem/pages/login/css/login.css">

    <title>登录页面</title>
</head>

<body>
<div class="container">
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
                <input type="text" class="form-control" placeholder="用户名/邮箱" name="username">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group  has-feedback">
                <input type="password" class="form-control" placeholder="密码" name="password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <button class="btn btn-block btn-flat pull-right" id="btn-login">登录</button>
        </form>

    </div>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/ssmTicketSystem/static/js/jquery-3.4.1.js"></script>

<!--  Bootstrap 核心 JavaScript 文件 -->
<script src="/ssmTicketSystem/static/js/bootstrap.min.js"></script>

<script src="/ssmTicketSystem/pages/login/js/login.js"></script>
</body>

</html>
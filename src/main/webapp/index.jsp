<%--
  Created by IntelliJ IDEA.
  User: YuanJie Li
  Date: 2019/12/31
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta charset="utf-8"/>
    <title>云端购票系统</title>
    <link rel="stylesheet" type="text/css" href="/ssmTicketSystem/static/css/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="/ssmTicketSystem/static/css/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="/ssmTicketSystem/static/css/index.css"/>
</head>

<body class="easyui-layout" id="layout" style="visibility:hidden;">
<!-- 头部 -->
<div data-options="region:'north'" id="header">
    <img src="/ssmTicketSystem/static/images/logo.jpg" class="logo"/>
    <img src="/ssmTicketSystem/static/images/logo1.jpg" class="logo1"/>
    <img src="/ssmTicketSystem/static/images/logo1.jpg" class="logo1"/>
    <img src="/ssmTicketSystem/static/images/logo1.jpg" class="logo1"/>
    <img src="/ssmTicketSystem/static/images/logo1.jpg" class="logo1"/>
    <img src="/ssmTicketSystem/static/images/logo1.jpg" class="logo1"/>
    <img src="/ssmTicketSystem/static/images/logo1.jpg" class="logo1"/>
    <img src="/ssmTicketSystem/static/images/logo1.jpg" class="logo1"/>
    <img src="/ssmTicketSystem/static/images/logo1.jpg" class="logo1"/>
    <img src="/ssmTicketSystem/static/images/logo1.jpg" class="logo1"/>
    <img src="/ssmTicketSystem/static/images/logo1.jpg" class="logo1"/>
    <img src="/ssmTicketSystem/static/images/logo1.jpg" class="logo1"/>
    <img src="/ssmTicketSystem/static/images/logo1.jpg" class="logo1"/>
    <img src="/ssmTicketSystem/static/images/logo1.jpg" class="logo1"/>
    <img src="/ssmTicketSystem/static/images/logo1.jpg" class="logo1"/>


    <div class="top-btns">
        <span>欢迎您 ${sessionScope.user.username}</span>
        <a href="/ssmTicketSystem/pages/user/changepwd.jsp" class="easyui-linkbutton"
           data-options="plain:true,iconCls:'icon-lock'">修改密码</a>
        <a href="/logout" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-undo'">退出系统</a>
    </div>
</div>

<!-- 左边菜单 -->
<div region="west" title="导航菜单" id="naver">
    <div class="easyui-accordion" id="navmenu" data-options="fit:false">
        <c:forEach var="firstMenu" items="${sessionScope.menuLists}">
            <div title="${firstMenu.menuname}">
                <ul class="navmenu">
                    <c:forEach var="secondMenu" items="${firstMenu.child}">
                        <li><a href="javascript:void(0)" data-url="${secondMenu.menuurl}">${secondMenu.menuname}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </c:forEach>
    </div>
</div>

<!-- 中间内容 -->
<div region="center" id="content">
    <div class="easyui-tabs" fit="true" id="tabs">
        <div title="首页" iconCls="icon-ok">
            <div id="notice-refresh" class="easyui-panel" title="系统公告" headerCls='notice-tophead'
                 data-options="fit:true">
                <div class="easyui-accordion" data-options="fit:false,border:false" id="notices">
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 底部 -->
<div region="south" id="footer">云端购票系统 V1.0</div>

<script type="text/javascript" src="/ssmTicketSystem/static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/ssmTicketSystem/static/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/ssmTicketSystem/static/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/ssmTicketSystem/static/js/index.js"></script>
</body>

</html>

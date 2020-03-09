<%--
  Created by IntelliJ IDEA.
  User: qin
  Date: 2019/12/31
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>

<html>

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta charset="utf-8"/>
    <title>云端购票系统</title>
    <link rel="stylesheet" type="text/css" href="/ssmTicketSystem/static/css/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="/ssmTicketSystem/static/css/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="/ssmTicketSystem/static/css/index.css"/>
    <script type="text/javascript" src="/ssmTicketSystem/static/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="/ssmTicketSystem/static/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/ssmTicketSystem/static/js/index.js"></script>
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
        <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-lock'">修改密码</a>
        <a href="/logout" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-undo'">退出系统</a>
    </div>
</div>

<!-- 左边菜单 -->
<div region="west" title="导航菜单" id="naver">
    <div class="easyui-accordion" id="navmenu">
        <div title="指标体系">
            <ul class="navmenu">
                <li class="active"><a href="#">首页</a></li>
                <li><a href="#" data-url="html/page01.html">组织机构管理</a></li>
                <li><a href="#" data-url="html/page02.html">指标库列表</a></li>
            </ul>
        </div>
        <div title="绩效考核"></div>
        <div title="报表管理"></div>
        <div title="系统管理"></div>
        <div title="组件示例">
            <ul class="navmenu">
                <li><a href="#" data-url="html/demo01.html">锁定行和列</a></li>
            </ul>
        </div>
    </div>
</div>

<div region="center" id="content">
    <div class="easyui-tabs" fit="true" id="tabs">

        <div title="首页" iconCls="icon-ok">
            <div class="easyui-accordion" data-options="fit:true">
                <div title="待办事项">
                    <div class="flow-panel">
                        <div class="flow-todo">
                            <ul class="todo-list">
                                <li>
                                    <span>代办事项 A</span>
                                    <a href="#" class="num">5</a>
                                </li>
                                <li>
                                    <span>代办事项 B</span>
                                    <a href="#" class="num">5</a>
                                </li>
                                <li>
                                    <span>代办事项 C</span>
                                    <a href="#" class="num">5</a>
                                </li>
                                <li>
                                    <span>代办事项 D</span>
                                    <a href="#" class="num">5</a>
                                </li>
                                <li>
                                    <span>代办事项 E</span>
                                    <a href="#" class="num">5</a>
                                </li>
                                <li>
                                    <span>代办事项 F</span>
                                    <a href="#" class="num">5</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div title="系统公告">
                    <ul class="notice-list">
                        <li>
                            <span>这是一条系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告</span>
                            <span class="date">2015-10-30</span>
                        </li>
                        <li>
                            <span>这是一条系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告</span>
                            <span class="date">2015-10-30</span>
                        </li>
                        <li>
                            <span>这是一条很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长的系统公告</span>
                            <span class="date">2015-10-30</span>
                        </li>
                        <li>
                            <span>这是一条系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告</span>
                            <span class="date">2015-10-30</span>
                        </li>
                        <li>
                            <span>这是一条系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告</span>
                            <span class="date">2015-10-30</span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

    </div>
</div>

<div region="south" id="footer">云端购票系统 V1.0</div>

</body>

</html>

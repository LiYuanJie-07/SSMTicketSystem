<%--
  Created by IntelliJ IDEA.
  User: qin
  Date: 2020/3/14
  Time: 15:13
  To change this template use File | Settings | File Templates.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!-- 公告管理 -->
<!-- 数据表 -->
<table class="easyui-datagrid" title="公告列表" id="dg-notice" data-options="
        fit:true,
        striped:true,
        fitColumns:true,
        rownumbers:true,
        remoteSort:false,
        singleSelect:true,
        scrollbarSize:'0',
        toolbar:'#toolbar',
        ">
    <thead>
    <tr>
        <th field="noticeid" align="center" sortable="true" hidden="true">公告编号</th>
        <th field="" checkbox="true" align="center"></th>
        <th field="noticetitle" width="17" align="center" sortable="true">公告标题</th>
        <th field="noticetext" width="76" align="center" sortable="true">公告内容</th>
        <th field="noticetime" width="7" align="center" sortable="true">修改时间</th>
    </tr>
    </thead>
</table>
<!-- /数据表 -->

<!-- 数据表工具栏 -->
<div class="toolbar" id="toolbar">
    <div class="ctrl-div">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="btn-add">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
           id="btn-remove">删除</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="btn-edit">编辑</a>
    </div>
</div>
<!-- /数据表工具栏 -->


<!-- 新增公告模态框 -->
<div id="dlg-add" class="easyui-dialog" title="公告新增" style="width:600px;height:300px;padding:2px;" data-options="
				iconCls: 'icon-save',
				toolbar: '#dlg-add-toolbar',
                buttons: '#dlg-add-buttons',
                modal:true,
                closed:true
			">
    <!-- 公告内容 -->
    <input class="easyui-textbox" type="text" id="add-noticetext"
           data-options="multiline:true,fit:true,prompt:'请在此输入公告内容'"/>
</div>
<!-- 公告标题 -->
<div id="dlg-add-toolbar">
    <span style="margin-left:2px;font-size: 12px;">公告标题 :</span>
    <input class="easyui-textbox" type="text" id="add-noticetitle" style="width: 200px;"
           data-options="prompt:'请输入公告标题'"/>
</div>
<!-- 模态框按钮 -->
<div id="dlg-add-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-ok' id="btn-add-ok">确定</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-cancel' id="btn-add-cancel">取消</a>
</div>
<!-- /新增公告模态框 -->

<!-- 修改公告模态框 -->
<div id="dlg-edit" class="easyui-dialog" title="修改公告" style="width:600px;height:300px;padding:2px;" data-options="
        iconCls: 'icon-save',
        toolbar: '#dlg-edit-toolbar',
        buttons: '#dlg-edit-buttons',
        modal:true,
        closed:true
    ">
    <!-- 公告内容 -->
    <input class="easyui-textbox" type="text" id="edit-noticetext" data-options="multiline:true,fit:true"/>
</div>
<!-- 公告标题 -->
<div id="dlg-edit-toolbar">
    <span style="margin-left:2px;font-size: 12px;">公告标题 :</span>
    <input class="easyui-textbox" type="text" id="edit-noticetitle" style="width: 200px;"/>
</div>
<!-- 模态框按钮 -->
<div id="dlg-edit-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-ok' id="btn-edit-ok">确定</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-cancel' id="btn-edit-cancel">取消</a>
</div>
<!-- /新增公告模态框 -->

<!-- /公告管理 -->
<script type="text/javascript" src="/ssmTicketSystem/pages/notice/js/notice.js"></script>
